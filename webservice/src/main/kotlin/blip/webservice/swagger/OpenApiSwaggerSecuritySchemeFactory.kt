package blip.webservice.swagger

import io.swagger.v3.oas.models.security.OAuthFlow
import io.swagger.v3.oas.models.security.OAuthFlows
import io.swagger.v3.oas.models.security.Scopes
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.security.SecurityScheme.Type.OAUTH2

object OpenApiSwaggerSecuritySchemeFactory {

  fun scheme(authorisationUrl: String): SecurityScheme =
    SecurityScheme()
      .type(OAUTH2)
      .flows(flows(authorisationUrl))

  private fun flows(authorisationUrl: String): OAuthFlows =
    OAuthFlows().implicit(flow(authorisationUrl))

  private fun flow(authorisationUrl: String): OAuthFlow =
    OAuthFlow()
      .authorizationUrl(authorisationUrl)
      .scopes(Scopes())
}