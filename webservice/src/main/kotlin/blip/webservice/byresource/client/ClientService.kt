package blip.webservice.byresource.client

import blip.resource.BlipResourceType.ClientResource
import blip.resource.client.command.RegisterClientCommand
import blip.resource.client.entity.Client
import blip.resource.client.query.ClientByIdQuery
import blip.resource.client.query.ClientByNameQuery
import blip.resource.client.toClient
import blip.resource.client.toClientRegisteredEvent
import blip.webservice.eventbus.BlipEventChannel.AllClientEventsChannel
import blip.webservice.eventbus.PublishableEventBus
import blip.webservice.exceptions.BlipExceptions.resourceAlreadyExistsException
import blip.webservice.exceptions.BlipExceptions.resourceDoesNotExistException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class ClientService(
  @Autowired private val repo: ClientRepo,
  @Autowired private val eventBus: PublishableEventBus
) {

  fun processRegisterClientCommand(@Valid command: RegisterClientCommand): Client = with(command) {
    if (repo.existsByNameIgnoreCase(name))
      throw resourceAlreadyExistsException(ClientResource, "name", name)
    val entity = command.toClient()
    val savedEntity = repo.save(entity)
    val event = savedEntity.toClientRegisteredEvent()
    eventBus.publishEventToChannel(AllClientEventsChannel, event)
    return savedEntity
  }

  fun processClientByIdQuery(@Valid query: ClientByIdQuery): Client = with(query) {
    repo.findByIdOrNull(id) ?: throw resourceDoesNotExistException(ClientResource, "id", id)
  }

  fun processClientByNameQuery(@Valid query: ClientByNameQuery): Client = with(query) {
    repo.getClientByNameIgnoreCase(name) ?: throw resourceDoesNotExistException(ClientResource, "name", name)
  }
}