package blip.webservice.byresource.person

import blip.resource.person.Person
import blip.resource.person.RegisterPersonCommand
import blip.resource.person.toPerson
import blip.resource.person.toPersonRegisteredEvent
import blip.webservice.eventbus.EventBus
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import java.security.Principal

@Service
@Validated
class PersonService(
  @Autowired private val repo: PersonRepo,
  @Autowired private val eventBus: EventBus
) {

  fun processRegisterPersonCommand(@Valid command: RegisterPersonCommand): Person {
    val entity = command.toPerson()
    val savedEntity = repo.save(entity)
    eventBus.postEvent(savedEntity.toPersonRegisteredEvent())
    return savedEntity
  }

  fun personOrThrowForPrincipal(principal: Principal): Person =
    repo.findByPrincipalName(principal.name)
      ?: throw EntityNotFoundException("Person with principal name [${principal.name}] not found")

  fun personCreateIfNecessary(principal: Principal): Person =
    repo.findByPrincipalName(principal.name)
      ?: processRegisterPersonCommand(RegisterPersonCommand(principal.name))

//  fun personCreateIfNecessary(principal: Principal): Person =
//    repo.findByPrincipalName(principal.name)
//      ?: register(PersonDto(principal.name), principal)
//
//  fun person(id: PersonId): Person = repo.getReferenceById(id)
//
//  fun personOrThrowForPrincipal(principal: Principal): Person = repo.findByPrincipalName(principal.name)
//    ?: throw EntityNotFoundException("Person with principal name [${principal.name}] not found")
}