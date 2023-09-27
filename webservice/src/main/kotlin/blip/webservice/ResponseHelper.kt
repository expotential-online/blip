package blip.webservice

import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

object ResponseHelper {

  fun <T, I> creationResponse(resource: T, idExtractor: (T) -> I?): ResponseEntity<T> =
    ResponseEntity.created(uriForResource(resource, idExtractor)).build()

  fun <T> viewResponse(payload: T): ResponseEntity<T> = ResponseEntity.ok(payload)

  private fun <T, I> uriForResource(resource: T, idExtractor: (T) -> I?): URI =
    ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(idExtractor.invoke(resource).toString())
      .toUri()
}