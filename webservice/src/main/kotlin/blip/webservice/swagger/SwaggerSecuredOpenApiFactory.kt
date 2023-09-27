package blip.webservice.swagger

import blip.webservice.swagger.OpenApiSwaggerSecuritySchemeFactory.scheme
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement

object SwaggerSecuredOpenApiFactory {

  fun securedOpenApi(authorisationUrl: String, securitySchemeName: String): OpenAPI =
    OpenAPI()
      .addSecurityItem(
        SecurityRequirement().addList(securitySchemeName)
      )
      .components(
        Components().addSecuritySchemes(securitySchemeName, scheme(authorisationUrl))
      )
      .info(Info().title("Hello world"))
}