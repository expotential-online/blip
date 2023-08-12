package blip.webservice.service

import blip.model.PersonId
import blip.model.person.Person
import blip.model.person.PersonDto
import blip.model.person.PersonMapper
import blip.webservice.repo.PersonRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService(@Autowired private val repo: PersonRepo) :
  AbstractModelService<Person, PersonId, PersonDto>(repo, PersonMapper)