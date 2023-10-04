package blip.testclient

import blip.resource.BlipApi
import blip.resource.BlipApiVersion.V1_0
import blip.resource.BlipResourceType
import blip.resource.BlipResourceType.AgentResource
import blip.resource.BlipResourceType.AgentTypeResource
import blip.resource.agent.rest.AgentPostPayload
import blip.resource.agenttype.rest.AgentTypePostPayload
import blip.testclient.TestUser.AdminUser
import org.apache.http.impl.client.DefaultHttpClient
import org.keycloak.authorization.client.AuthzClient
import org.keycloak.authorization.client.Configuration
import org.keycloak.representations.idm.authorization.AuthorizationRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.core.env.Environment
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus.CREATED
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.concurrent.atomic.AtomicInteger

@Service
class TestClientService(
  @Value("\${blip.webservice.url}") private val webserviceUrl: String,
  @Value("\${blip.keycloak.url}") private val keycloakUrl: String,
  @Value("\${blip.keycloak.realm}") private val keycloakRealm: String,
  @Value("\${blip.keycloak.client_id}") private val keycloakClientId: String,
  @Value("\${blip.keycloak.secret}") private val keycloakSecret: String,
  @Autowired private val environment: Environment
) {

  private val logger = LoggerFactory.getLogger(javaClass)
  private val authorisationClient = authorisationClient()
  private val tokensByUser = tokensByUser()
  private val nextStepNumber = AtomicInteger(1)

  @EventListener(ApplicationReadyEvent::class)
  fun prepareEnvironment() {
    registerOrCreate(AgentTypeResource, AgentTypePostPayload("Blip"), AdminUser)
    registerOrCreate(AgentTypeResource, AgentTypePostPayload("Microsoft Teams"), AdminUser)
    registerOrCreate(AgentTypeResource, AgentTypePostPayload("WhatsApp"), AdminUser)
    registerOrCreate(AgentResource, AgentPostPayload("Blip instance 1", "Blip"), AdminUser)
    registerOrCreate(AgentResource, AgentPostPayload("Teams instance 1", "Microsoft Teams"), AdminUser)
    registerOrCreate(AgentResource, AgentPostPayload("Teams instance 2", "Microsoft Teams"), AdminUser)
  }

  private fun authorisationClient(): AuthzClient =
    AuthzClient.create(
      Configuration(
        keycloakUrl, keycloakRealm, keycloakClientId, mapOf("secret" to keycloakSecret), DefaultHttpClient()
      )
    )

  private fun tokensByUser(): Map<TestUser, AuthToken> =
    TestUser.entries.associateWith { token(it) }

  private fun token(user: TestUser): AuthToken {
    val request = AuthorizationRequest()
    val username = user.username(environment)
    val password = user.password(environment)
    logger.info("Obtaining token for user [$username]")
    val authorization = authorisationClient.authorization(username, password)
    val response = authorization.authorize(request)
    val token = response.token
    logger.info("Token [$token] obtained for user [$username]")
    return token
  }

  private fun <T> registerOrCreate(resource: BlipResourceType, payload: T, user: TestUser): String {
    val stepNumber = nextStepNumber.getAndIncrement()
    val token = tokensByUser[user]
    val url = BlipApi.resourcePostUrl(webserviceUrl, V1_0, resource)
    val headers = HttpHeaders()
    headers.set("Authorization", "Bearer $token")
    val entity = HttpEntity(payload, headers)
    val template = RestTemplate()
    logger.info("Performing step [$stepNumber]: POST to URL [$url]")
    val responseEntity = template.postForEntity(url, entity, String::class.java)
    val statusCode = responseEntity.statusCode
    if (CREATED.equals(statusCode)) {
      val location = responseEntity.headers["location"]
      logger.info("Step [$stepNumber] created resource with URL $location")
    } else {
      logger.error("Step [$stepNumber] returned code [${statusCode.value()}] but expected [${CREATED}]")
    }
    return responseEntity.toString()
  }
}