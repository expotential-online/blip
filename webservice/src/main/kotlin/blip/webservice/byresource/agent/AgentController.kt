package blip.webservice.byresource.agent

import blip.resource.BlipApiVersion
import blip.resource.BlipApiVersion.UrlParts.V1_0
import blip.resource.BlipResourceType.AgentTypeResource
import blip.resource.BlipResourceType.UrlParts.AgentResources
import blip.resource.agent.AgentId
import blip.resource.agent.codec.toAgentGetResponse
import blip.resource.agent.codec.toRegisterAgentCommand
import blip.resource.agent.entity.Agent
import blip.resource.agent.query.SingleAgentQuery
import blip.resource.agent.rest.AgentGetResponse
import blip.resource.agent.rest.AgentPostPayload
import blip.webservice.BlipEnvironmentService
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
@RequestMapping("/$V1_0/$AgentResources")
class AgentController(
  @Autowired private val service: AgentService,
  @Autowired private val environmentService: BlipEnvironmentService
) {

  @PostMapping
  @Secured(ADMINISTRATOR)
  fun onPost(@RequestBody payload: AgentPostPayload, principal: Principal): ResponseEntity<Agent> {
    val command = payload.toRegisterAgentCommand()
    val entity = service.processRegisterAgentCommand(command)
    return creationResponse(entity) { it.id }
  }

  @GetMapping("/{id}")
  @Secured(ADMINISTRATOR)
  fun onGet(@PathVariable id: AgentId): ResponseEntity<AgentGetResponse> {
    val query = SingleAgentQuery(id)
    val entity = service.processSingleAgentQuery(query)
    val typeUrl = environmentService.resourceGetUrl(BlipApiVersion.V1_0, AgentTypeResource, entity.type!!.id)
    val response = entity.toAgentGetResponse(typeUrl)
    return viewResponse(response)
  }
}