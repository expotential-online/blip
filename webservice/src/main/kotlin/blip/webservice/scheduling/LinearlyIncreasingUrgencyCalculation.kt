package blip.webservice.scheduling

import blip.webservice.Urgency
import blip.webservice.scheduling.UrgencyCalculation.Companion.TooEarly
import blip.webservice.scheduling.UrgencyCalculation.Companion.TooLate
import java.time.Duration
import java.time.Duration.between
import java.time.ZonedDateTime

object LinearlyIncreasingUrgencyCalculation : UrgencyCalculation {
  override fun urgency(
    earliestStart: ZonedDateTime,
    latestFinish: ZonedDateTime,
    now: ZonedDateTime,
    toDo: Duration
  ): Urgency {
    if (now.isBefore(earliestStart))
      return TooEarly
    val latestStart = latestFinish.minus(toDo)
    if (now.isAfter(latestStart))
      return TooLate
    val earliestToLatestStart = between(earliestStart, latestStart)
    if (earliestToLatestStart.isNegative)
      return TooLate
    val earliestStartToNow = between(earliestStart, now)
    return earliestStartToNow.toMillis().toDouble() / earliestToLatestStart.toMillis()
  }
}