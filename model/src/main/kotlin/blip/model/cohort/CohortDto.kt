package blip.model.cohort

import blip.model.CohortName
import blip.model.Constraints.CohortNameMaxLength
import blip.model.Constraints.CohortNameMinLength
import javax.validation.constraints.Size

data class CohortDto(

  @get:Size(min = CohortNameMinLength, max = CohortNameMaxLength)
  val name: CohortName
)