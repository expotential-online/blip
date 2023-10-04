package blip.webservice.scheduling

import blip.webservice.Urgency
import java.time.Duration
import java.time.ZonedDateTime
import kotlin.Double.Companion.NEGATIVE_INFINITY
import kotlin.Double.Companion.POSITIVE_INFINITY

interface UrgencyCalculation {
  fun urgency(earliestStart: ZonedDateTime, latestFinish: ZonedDateTime, now: ZonedDateTime, toDo: Duration): Urgency

  companion object {
    const val TooEarly: Urgency = NEGATIVE_INFINITY
    const val TooLate: Urgency = POSITIVE_INFINITY
    const val MinimumUrgency: Urgency = 0.0
    const val MaximumUrgency: Urgency = 1.0

    fun isTooEarly(urgency: Urgency): Boolean = urgency == TooEarly
    fun isTooLate(urgency: Urgency): Boolean = urgency == TooLate
    fun isMinimal(urgency: Urgency): Boolean = urgency == MinimumUrgency
    fun isMaximal(urgency: Urgency): Boolean = urgency == MaximumUrgency
  }
}