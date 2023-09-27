package blip.resource.person

import blip.core.PersonPrincipalName
import blip.core.command.AbstractCommand

data class RegisterPersonCommand(
  val principalName: PersonPrincipalName
) : AbstractCommand()