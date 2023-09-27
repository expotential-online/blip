package blip.core.query

import blip.core.Timestamped
import blip.core.UtcEpochMilliseconds
import java.lang.System.currentTimeMillis

abstract class AbstractQuery : Timestamped {
  override val timestamp: UtcEpochMilliseconds
    get() = currentTimeMillis()
}