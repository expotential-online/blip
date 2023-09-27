package blip.resource.person

fun RegisterPersonCommand.toPerson(): Person = with(this) {
  Person(principalName)
}

fun Person.toPersonRegisteredEvent(): PersonRegisteredEvent = with(this) {
  PersonRegisteredEvent(id!!, principalName!!)
}

fun PersonPostPayload.toRegisterPersonCommand(): RegisterPersonCommand = with(this) {
  RegisterPersonCommand(principalName)
}