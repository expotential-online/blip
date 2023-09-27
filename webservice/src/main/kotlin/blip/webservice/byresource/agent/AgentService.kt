package blip.webservice.byresource.agent

import blip.resource.BlipResourceType.AgentResource
import blip.resource.BlipResourceType.AgentTypeResource
import blip.resource.agent.Agent
import blip.resource.agent.RegisterAgentCommand
import blip.resource.agent.toAgentRegisteredEvent
import blip.resource.agent.toAgentWithType
import blip.webservice.byresource.agenttype.AgentTypeService
import blip.webservice.eventbus.EventBus
import blip.webservice.exceptions.BlipExceptions.resourceAlreadyExistsException
import blip.webservice.exceptions.BlipExceptions.resourceDoesNotExistException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class AgentService(
  @Autowired private val repo: AgentRepo,
  @Autowired private val agentTypeService: AgentTypeService,
  @Autowired private val eventBus: EventBus
) {

  fun processRegisterAgentCommand(@Valid command: RegisterAgentCommand): Agent {
    if (repo.existsAgentByNameEqualsIgnoreCase(command.name))
      throw resourceAlreadyExistsException(AgentResource, "name", command.name)
    val agentType = agentTypeService.agentTypeNamed(command.typeName)
      ?: throw resourceDoesNotExistException(AgentTypeResource, "name", command.typeName)
    val entity = command.toAgentWithType(agentType)
    val savedEntity = repo.save(entity)
    eventBus.postEvent(savedEntity.toAgentRegisteredEvent())
    return savedEntity
  }
}