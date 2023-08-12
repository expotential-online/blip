package blip.webservice.service

import blip.model.CohortId
import blip.model.cohort.Cohort
import blip.model.cohort.CohortDto
import blip.model.cohort.CohortMapper
import blip.webservice.repo.CohortRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CohortService(@Autowired private val repo: CohortRepo) :
  AbstractModelService<Cohort, CohortId, CohortDto>(repo, CohortMapper)