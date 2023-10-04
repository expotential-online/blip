package blip.resource.client.command

import blip.core.command.AbstractCommand
import blip.resource.client.ClientConstraints.ClientDescriptionMaxLength
import blip.resource.client.ClientConstraints.ClientDescriptionMinLength
import blip.resource.client.ClientConstraints.ClientNameRegex
import blip.resource.client.ClientDescription
import blip.resource.client.ClientName
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class RegisterClientCommand(

  @get:Pattern(regexp = ClientNameRegex)
  val name: ClientName,

  @get:Size(min = ClientDescriptionMinLength, max = ClientDescriptionMaxLength)
  val description: ClientDescription
) : AbstractCommand()
