package blip.model.person

import blip.model.PersonForename
import blip.model.PersonId
import blip.model.PersonSurname
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person(

  var forename: PersonForename?,

  var surname: PersonSurname?,

  @Id @GeneratedValue
  var id: PersonId? = null
)