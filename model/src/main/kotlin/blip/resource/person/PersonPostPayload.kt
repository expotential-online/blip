package blip.resource.person

import blip.core.PersonPrincipalName

data class PersonPostPayload(
  val principalName: PersonPrincipalName
)
