package blip.webservice.controller

import blip.model.PersonId
import blip.model.person.Person
import blip.model.person.PersonDto
import blip.webservice.ResponseHelper.creationResponse
import blip.webservice.Versions.v1_0
import blip.webservice.service.PersonService
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/$v1_0/people")
class PersonController(
  @Autowired private val service: PersonService
) {

  private val logger = getLogger(javaClass)

  @PostMapping
  fun registerPerson(@RequestBody dto: PersonDto): ResponseEntity<Person> {
    logger.debug("Registering person with forename [${dto.forename}] and surname ${dto.surname}")
    val person = service.register(dto)
    return creationResponse(person, Person::id)
  }

  @GetMapping("/{id}")
  fun viewPerson(@PathVariable id: PersonId): ResponseEntity<Person> {
    val person = service.view(id)
    return ok(person)
  }
}