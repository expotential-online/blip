package blip.webservice.byresource.blip

import blip.resource.BlipApiVersion.UrlParts.V1_0
import blip.resource.BlipResourceType.UrlParts.BlipResources
import blip.resource.blip.Blip
import blip.resource.blip.BlipPostPayload
import blip.resource.blip.toCreateBlipCommand
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
@RequestMapping("/$V1_0/$BlipResources")
class BlipController(@Autowired private val service: BlipService) {

  @PostMapping
  @Secured(USER)
  fun onPost(@RequestBody payload: BlipPostPayload, principal: Principal): ResponseEntity<Blip> {
    val command = payload.toCreateBlipCommand(principal)
    val entity = service.processCreateBlipCommand(command, principal)
    return creationResponse(entity) { it.id }
  }

//  @PostMapping
//  @Secured(USER)
//  override fun register(@RequestBody dto: BlipDto, principal: Principal): ResponseEntity<Blip> {
//    val model = service.register(dto, principal)
//    return creationResponse(model) { it.id }
//  }
//
//  @GetMapping("/{id}")
//  override fun view(@PathVariable id: BlipId, principal: Principal): ResponseEntity<Blip> {
//    val auth = SecurityContextHolder.getContext().authentication
//    val model = service.view(id, principal)
//    return ResponseEntity.ok(model)
//  }
}