package blip.webservice.byresource.agenttype

import blip.core.AgentTypeId
import blip.resource.BlipApiVersion.UrlParts.V1_0
import blip.resource.BlipResourceType.UrlParts.AgentTypeResources
import blip.resource.agenttype.AgentType
import blip.resource.agenttype.AgentTypeGetResponse
import blip.resource.agenttype.AgentTypePostPayload
import blip.resource.agenttype.SingleAgentTypeQuery
import blip.resource.agenttype.toAgentTypeGetResponse
import blip.resource.agenttype.toRegisterAgentTypeCommand
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
@RequestMapping("/$V1_0/$AgentTypeResources")
class AgentTypeController(@Autowired private val service: AgentTypeService) {

  @PostMapping
  @Secured(ADMINISTRATOR)
  fun onPost(@RequestBody payload: AgentTypePostPayload, principal: Principal): ResponseEntity<AgentType> {
    val command = payload.toRegisterAgentTypeCommand()
    val entity = service.processRegisterAgentTypeCommand(command)
    return creationResponse(entity) { it.id }
  }

  @GetMapping("/{id}")
  @Secured(ADMINISTRATOR)
  fun onGet(@PathVariable id: AgentTypeId, principal: Principal): ResponseEntity<AgentTypeGetResponse> {
    val query = SingleAgentTypeQuery(id)
    val entity = service.processSingleAgentTypeQuery(query)
    val response = entity.toAgentTypeGetResponse()
    return viewResponse(response)
  }
}