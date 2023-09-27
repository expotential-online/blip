package blip.webservice.byresource.agenttype

import blip.core.AgentTypeName
import blip.resource.BlipResourceType.AgentTypeResource
import blip.resource.agenttype.AgentType
import blip.resource.agenttype.RegisterAgentTypeCommand
import blip.resource.agenttype.SingleAgentTypeQuery
import blip.resource.agenttype.toAgentType
import blip.resource.agenttype.toAgentTypeRegisteredEvent
import blip.webservice.eventbus.EventBus
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
  @Autowired private val eventBus: EventBus
) {

  fun processRegisterAgentTypeCommand(@Valid command: RegisterAgentTypeCommand): AgentType {
    if (repo.existsAgentTypeByNameEqualsIgnoreCase(command.name))
      throw resourceAlreadyExistsException(AgentTypeResource, "name", command.name)
    val entity = command.toAgentType()
    val savedEntity = repo.save(entity)
    eventBus.postEvent(savedEntity.toAgentTypeRegisteredEvent())
    return savedEntity
  }

  fun processSingleAgentTypeQuery(@Valid query: SingleAgentTypeQuery): AgentType {
    val entity = repo.findByIdOrNull(query.id)
      ?: throw resourceDoesNotExistException(AgentTypeResource, "id", query.id.toString())
    return entity
  }

  fun agentTypeNamed(name: AgentTypeName): AgentType? {
    return repo.findByNameEqualsIgnoreCase(name)
  }
}