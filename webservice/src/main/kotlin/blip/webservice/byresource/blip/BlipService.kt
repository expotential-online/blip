package blip.webservice.byresource.blip

import blip.core.BlipList
import blip.resource.blip.Blip
import blip.resource.blip.CreateBlipCommand
import blip.resource.blip.toBlip
import blip.resource.blip.toBlipCreatedEvent
import blip.resource.person.Person
import blip.webservice.byresource.person.PersonService
import blip.webservice.eventbus.BlipEventChannel.AllBlipEventsChannel
import blip.webservice.eventbus.InProcessEventBusService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import java.security.Principal

@Service
@Validated
class BlipService(
  @Autowired private val repo: BlipRepo,
  @Autowired private val personService: PersonService,
  @Autowired private val eventBusService: InProcessEventBusService
) {

  fun processCreateBlipCommand(@Valid command: CreateBlipCommand, principal: Principal): Blip {
    val originatingPerson = personService.personOrThrowForPrincipal(principal)
    val entity = command.toBlip(originatingPerson)
    val savedEntity = repo.save(entity)
    eventBusService.publishEventToChannel(AllBlipEventsChannel, savedEntity.toBlipCreatedEvent())
    return savedEntity
  }

  fun blipsOriginatedBy(@NotNull person: Person): BlipList =
    repo.findByOriginator(person)

//  fun register(@Valid dto: BlipDto, principal: Principal): Blip {
//    val person = personService.personCreateIfNecessary(principal)
//    val model = BlipMapper.toModel(dto, person)
//    return repo.save(model)
//  }
//
//  fun view(id: BlipId, principal: Principal): Blip {
//    return repo.getById(id)
//  }
//
//  fun blipsOriginatedBy(@NotNull person: Person): BlipList {
//    return repo.findByOriginator(person)
//  }
}