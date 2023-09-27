package blip.webservice.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.security.web.authentication.logout.LogoutHandler
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class KeycloakLogoutHandler() : LogoutHandler {

  private companion object {
    private const val LOGOUT_URL_SUFFIX = "/protocol/openid-connect/logout"
    private const val ID_TOKEN_HINT = "id_token_hint"
  }

  private val logger = LoggerFactory.getLogger(javaClass)
  private val restTemplate = RestTemplate()

  override fun logout(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication) {
    logout(authentication.principal as OidcUser)
  }

  private fun logout(user: OidcUser) {
    val endpoint = user.issuer.toString() + LOGOUT_URL_SUFFIX
    val uri = UriComponentsBuilder
      .fromUriString(endpoint)
      .queryParam(ID_TOKEN_HINT, user.idToken.tokenValue)
      .toString()
    val response = restTemplate.getForEntity(uri, String::class.java)
    if (response.statusCode.is2xxSuccessful) {
      logger.info("Keycloak logout succeeded")
    } else {
      logger.error("Keycloak logout failed")
    }
  }
}