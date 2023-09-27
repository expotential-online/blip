package blip.resource.blip

import blip.core.BlipSummary
import blip.core.command.AbstractCommand
import java.security.Principal

data class CreateBlipCommand(
  val summary: BlipSummary,
  val originator: Principal
) : AbstractCommand()
