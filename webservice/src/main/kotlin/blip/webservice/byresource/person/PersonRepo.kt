package blip.webservice.byresource.person

import blip.core.PersonId
import blip.core.PersonPrincipalName
import blip.resource.person.Person
import blip.webservice.Repo

interface PersonRepo : Repo<Person, PersonId> {
  fun findByPrincipalName(principalName: PersonPrincipalName): Person?
}