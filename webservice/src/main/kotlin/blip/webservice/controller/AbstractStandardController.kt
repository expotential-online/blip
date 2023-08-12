package blip.webservice.controller

import org.springframework.http.ResponseEntity

abstract class AbstractStandardController<D, M, I> : StandardController<D, M, I> {

  override fun register(dto: D): ResponseEntity<M> {
    TODO("Not yet implemented")
  }

  override fun view(id: I): ResponseEntity<M> {
    TODO("Not yet implemented")
  }
}