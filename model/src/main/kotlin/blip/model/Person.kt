package blip.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Person(
  var forename: PersonForename,
  var surname: PersonSurname,
  @Id @GeneratedValue var id: PersonId? = null
)