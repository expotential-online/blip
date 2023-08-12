package blip.model.person

import blip.model.Mapper

object PersonMapper : Mapper<PersonDto, Person> {
  override fun toModel(dto: PersonDto): Person = with(dto) {
    Person(forename, surname)
  }
}