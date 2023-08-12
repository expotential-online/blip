package blip.webservice.repo

import blip.model.PersonId
import blip.model.person.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepo : JpaRepository<Person, PersonId>