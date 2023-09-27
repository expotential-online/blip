package blip.webservice.byresource.agent

import blip.resource.BlipApiVersion.UrlParts.V1_0
import blip.resource.BlipResourceType.UrlParts.AgentResources
import blip.resource.agent.Agent
import blip.resource.agent.AgentPostPayload
import blip.resource.agent.toRegisterAgentCommand
import blip.webservice.ResponseHelper.creationResponse
import blip.webservice.security.Roles.ADMINISTRATOR
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/$V1_0/$AgentResources")
class AgentController(@Autowired private val service: AgentService) {

  @PostMapping
  @Secured(ADMINISTRATOR)
  fun onPost(@RequestBody payload: AgentPostPayload, principal: Principal): ResponseEntity<Agent> {
    val command = payload.toRegisterAgentCommand()
    val entity = service.processRegisterAgentCommand(command)
    return creationResponse(entity) { it.id }
  }
}