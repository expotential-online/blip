package blip.webservice.repo

import blip.model.CohortId
import blip.model.cohort.Cohort
import org.springframework.data.jpa.repository.JpaRepository

interface CohortRepo : JpaRepository<Cohort, CohortId>