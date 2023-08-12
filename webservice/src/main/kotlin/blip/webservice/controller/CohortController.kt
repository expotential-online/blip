package blip.webservice.controller

import blip.model.CohortId
import blip.model.cohort.Cohort
import blip.model.cohort.CohortDto
import blip.webservice.ResponseHelper.creationResponse
import blip.webservice.Versions.v1_0
import blip.webservice.service.CohortService
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
@RequestMapping("/$v1_0/cohorts")
class CohortController(
  @Autowired private val service: CohortService
) {

  private val logger = getLogger(javaClass)

  @PostMapping
  fun register(@RequestBody dto: CohortDto): ResponseEntity<Cohort> {
    logger.debug("Registering cohort with name [${dto.name}]")
    val cohort = service.register(dto)
    return creationResponse(cohort, Cohort::id)
  }

  @GetMapping("/{id}")
  fun view(@PathVariable id: CohortId): ResponseEntity<Cohort> {
    val cohort = service.view(id)
    return ok(cohort)
  }
}