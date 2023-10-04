package blip.webservice.byresource.client

import blip.resource.BlipApiVersion.UrlParts.V1_0
import blip.resource.BlipResourceType.UrlParts.ClientResources
import blip.resource.client.entity.Client
import blip.resource.client.query.ClientByIdQuery
import blip.resource.client.rest.ClientGetByIdResponsePayload
import blip.resource.client.rest.ClientPostRequestPayload
import blip.resource.client.toGetByIdResponsePayload
import blip.resource.client.toRegisterClientCommand
import blip.webservice.ResponseHelper.creationResponse
import blip.webservice.ResponseHelper.viewResponse
import blip.webservice.security.Roles.ADMINISTRATOR
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/$V1_0/$ClientResources")
class ClientController(
  @Autowired private val service: ClientService
) {

  @PostMapping
  @Secured(ADMINISTRATOR)
  fun onPost(@RequestBody payload: ClientPostRequestPayload, principal: Principal): ResponseEntity<Client> {
    val command = payload.toRegisterClientCommand()
    val entity = service.processRegisterClientCommand(command)
    return creationResponse(entity) { it.id }
  }

  @GetMapping("/{id}")
  @Secured(ADMINISTRATOR)
  fun onGetById(@PathVariable id: Long): ResponseEntity<ClientGetByIdResponsePayload> {
    val query = ClientByIdQuery(id)
    val entity = service.processClientByIdQuery(query)
    val response = entity.toGetByIdResponsePayload()
    return viewResponse(response)
  }
}