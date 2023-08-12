package blip.webservice

import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

object ResponseHelper {

  fun <T> creationResponse(resource: T, idExtractor: (T) -> Long?): ResponseEntity<T> =
    ResponseEntity.created(uriForResource(resource, idExtractor)).build()

  private fun <T> uriForResource(resource: T, idExtractor: (T) -> Long?): URI =
    ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(idExtractor.invoke(resource).toString())
      .toUri()
}