package blip.archive.model.cohort

import blip.archive.model.Constraints.CohortNameMaxLength
import blip.archive.model.Constraints.CohortNameMinLength
import blip.core.CohortName
import jakarta.validation.constraints.Size

data class CohortDto(

  @get:Size(min = CohortNameMinLength, max = CohortNameMaxLength)
  val name: CohortName
)