package blip.webservice.byresource.person

import blip.resource.BlipApiVersion.UrlParts.V1_0
import blip.resource.BlipResourceType.UrlParts.PersonResources
import blip.resource.person.Person
import blip.resource.person.PersonPostPayload
import blip.resource.person.toRegisterPersonCommand
import blip.webservice.ResponseHelper.creationResponse
import blip.webservice.security.Roles.USER
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/$V1_0/$PersonResources")
class PersonController(@Autowired private val service: PersonService) {

  @PostMapping
  @Secured(USER)
  fun onPost(@RequestBody payload: PersonPostPayload, principal: Principal): ResponseEntity<Person> {
    val command = payload.toRegisterPersonCommand()
    val entity = service.processRegisterPersonCommand(command)
    return creationResponse(entity) { it.id }
  }
}