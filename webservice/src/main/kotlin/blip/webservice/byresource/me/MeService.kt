package blip.webservice.byresource.me

import blip.webservice.byresource.blip.BlipService
import blip.webservice.byresource.person.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MeService(
  @Autowired private val personService: PersonService,
  @Autowired private val blipService: BlipService
) {


}