package blip.webservice.config

import blip.webservice.swagger.SwaggerSecuredOpenApiFactory.securedOpenApi
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig(
  @Value("\${spring.security.oauth2.client.provider.keycloak.issuer-uri}")
  private val authorisationUrlPrefix: String
) {

  @Bean
  fun openApi(): OpenAPI =
    securedOpenApi("$authorisationUrlPrefix/protocol/openid-connect/auth", "keycloak_scheme")
}