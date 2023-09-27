package blip.core.event

import blip.core.UtcEpochMilliseconds
import java.lang.System.currentTimeMillis

abstract class AbstractEvent : Event {
  override val timestamp: UtcEpochMilliseconds
    get() = currentTimeMillis()
}