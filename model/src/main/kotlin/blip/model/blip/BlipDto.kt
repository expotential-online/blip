package blip.model.blip

import blip.model.BlipSummary
import blip.model.Constraints.BlipSummaryMaxLength
import blip.model.Constraints.BlipSummaryMinLength
import javax.validation.constraints.Size

data class BlipDto(

  @get:Size(min = BlipSummaryMinLength, max = BlipSummaryMaxLength)
  val summary: BlipSummary
)
