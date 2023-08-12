package blip.model.person

import blip.model.Constraints.PersonForenameMaxLength
import blip.model.Constraints.PersonForenameMinLength
import blip.model.Constraints.PersonSurnameMaxLength
import blip.model.Constraints.PersonSurnameMinLength
import blip.model.PersonForename
import blip.model.PersonSurname
import javax.validation.constraints.Size

data class PersonDto(

  @get:Size(min = PersonForenameMinLength, max = PersonForenameMaxLength)
  val forename: PersonForename,

  @get:Size(min = PersonSurnameMinLength, max = PersonSurnameMaxLength)
  val surname: PersonSurname
)