package blip.webservice.byresource.agent

import blip.resource.BlipResourceType.AgentResource
import blip.resource.BlipResourceType.AgentTypeResource
import blip.resource.agent.codec.toAgentRegisteredEvent
import blip.resource.agent.codec.toAgentWithType
import blip.resource.agent.command.RegisterAgentCommand
import blip.resource.agent.entity.Agent
import blip.resource.agent.query.SingleAgentQuery
import blip.webservice.byresource.agenttype.AgentTypeService
import blip.webservice.eventbus.BlipEventChannel.AllAgentEventsChannel
import blip.webservice.eventbus.InProcessEventBusService
import blip.webservice.exceptions.BlipExceptions.resourceAlreadyExistsException
import blip.webservice.exceptions.BlipExceptions.resourceDoesNotExistException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class AgentService(
  @Autowired private val repo: AgentRepo,
  @Autowired private val agentTypeService: AgentTypeService,
  @Autowired private val eventBusService: InProcessEventBusService
) {

  fun processRegisterAgentCommand(@Valid command: RegisterAgentCommand): Agent {
    if (repo.existsAgentByNameEqualsIgnoreCase(command.name))
      throw resourceAlreadyExistsException(AgentResource, "name", command.name)
    val agentType = agentTypeService.agentTypeWithId(command.typeId)
      ?: throw resourceDoesNotExistException(AgentTypeResource, "id", command.typeId.toString())
    val entity = command.toAgentWithType(agentType)
    val savedEntity = repo.save(entity)
    eventBusService.publishEventToChannel(AllAgentEventsChannel, savedEntity.toAgentRegisteredEvent())
    return savedEntity
  }

  fun processSingleAgentQuery(@Valid query: SingleAgentQuery): Agent {
    val entity = repo.findByIdOrNull(query.id)
      ?: throw resourceDoesNotExistException(AgentResource, "id", query.id.toString())
    return entity
  }
}