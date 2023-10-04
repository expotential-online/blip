package blip.webservice.byresource.me

import blip.resource.BlipApiVersion.UrlParts.V1_0
import blip.resource.BlipResourceType.UrlParts.MeResources
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/$V1_0/$MeResources")
class MeController {

//  @GetMapping("/originated")
//  fun onGetOriginated(principal: Principal): Flux<BlipList> {
//    val person = personFor(principal)
//    blipService.blipsOriginatedBy(person)
//  }
//
//  private fun personFor(principal: Principal): Person =
//    personService.personCreateIfNecessary(principal)
}