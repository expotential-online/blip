package blip.webservice.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


interface StandardController<D, M, I> {

  @PostMapping
  fun register(@RequestBody dto: D): ResponseEntity<M>

  @GetMapping("/{id}")
  fun view(@PathVariable id: I): ResponseEntity<M>
}