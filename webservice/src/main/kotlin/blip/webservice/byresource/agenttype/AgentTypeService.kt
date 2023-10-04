package blip.webservice.byresource.agenttype

import blip.resource.BlipResourceType.AgentTypeResource
import blip.resource.agenttype.AgentTypeId
import blip.resource.agenttype.codec.toAgentType
import blip.resource.agenttype.codec.toAgentTypeRegisteredEvent
import blip.resource.agenttype.command.RegisterAgentTypeCommand
import blip.resource.agenttype.entity.AgentType
import blip.resource.agenttype.query.SingleAgentTypeQuery
import blip.webservice.eventbus.BlipEventChannel.AllAgentTypeEventsChannel
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
class AgentTypeService(
  @Autowired private val repo: AgentTypeRepo,
  @Autowired private val eventBusService: InProcessEventBusService
) {

  fun processRegisterAgentTypeCommand(@Valid command: RegisterAgentTypeCommand): AgentType {
    if (repo.existsAgentTypeByNameEqualsIgnoreCase(command.name))
      throw resourceAlreadyExistsException(AgentTypeResource, "name", command.name)
    val entity = command.toAgentType()
    val savedEntity = repo.save(entity)
    eventBusService.publishEventToChannel(AllAgentTypeEventsChannel, savedEntity.toAgentTypeRegisteredEvent())
    return savedEntity
  }

  fun processSingleAgentTypeQuery(@Valid query: SingleAgentTypeQuery): AgentType {
    val entity = repo.findByIdOrNull(query.id)
      ?: throw resourceDoesNotExistException(AgentTypeResource, "id", query.id.toString())
    return entity
  }

  fun agentTypeWithId(id: AgentTypeId): AgentType? {
    return repo.findByIdOrNull(id)
  }
}