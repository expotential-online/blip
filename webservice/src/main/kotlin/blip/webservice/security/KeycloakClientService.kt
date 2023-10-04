package blip.webservice.security

import blip.resource.client.entity.Client
import blip.resource.client.query.ClientByNameQuery
import blip.webservice.byresource.client.ClientService
import blip.webservice.security.KeycloakClaim.ClientName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.jwt.BadJwtException
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Service
import java.security.Principal

@Service
class KeycloakClientService(
  @Autowired private val clientService: ClientService
) {

  fun clientOf(principal: Principal): Client {
    // TODO: Improve this
    if (principal !is Jwt)
      throw BadJwtException("Not a JWT!!!")
    val clientName = principal.claimFromEnum<String>(ClientName) ?: throw BadJwtException("No client name claim")
    return clientService.processClientByNameQuery(ClientByNameQuery(clientName))
  }
}