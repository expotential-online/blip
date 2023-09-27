package blip.resource.person

import blip.core.Identifiable
import blip.core.PersonId
import blip.core.PersonPrincipalName
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Person(

  var principalName: PersonPrincipalName?,

  @Id
  @GeneratedValue
  override var id: PersonId? = null
) : Identifiable<PersonId>