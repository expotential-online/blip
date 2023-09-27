package blip.archive.model.blipownership

import blip.core.PersonId
import jakarta.validation.constraints.NotNull

data class BlipOwnershipDto(
  @get:NotNull
  val ownerId: PersonId
)