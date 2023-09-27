package blip.core.command

import blip.core.UtcEpochMilliseconds
import java.lang.System.currentTimeMillis

abstract class AbstractCommand : Command {
  override val timestamp: UtcEpochMilliseconds
    get() = currentTimeMillis()
}