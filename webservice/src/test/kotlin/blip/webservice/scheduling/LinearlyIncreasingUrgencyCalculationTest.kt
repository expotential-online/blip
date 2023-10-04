package blip.webservice.scheduling

import blip.webservice.scheduling.UrgencyCalculation.Companion.isMaximal
import blip.webservice.scheduling.UrgencyCalculation.Companion.isMinimal
import blip.webservice.scheduling.UrgencyCalculation.Companion.isTooEarly
import blip.webservice.scheduling.UrgencyCalculation.Companion.isTooLate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit.HOURS
import java.time.temporal.ChronoUnit.MINUTES

class LinearlyIncreasingUrgencyCalculationTest {

  private val londonTimezone: ZoneId = ZoneId.of("Europe/London")
  private val epsilon: Double = 1E-9

  @Test
  fun testNowBeforeEarliestStart() {
    assertTrue(
      isTooEarly(
        LinearlyIncreasingUrgencyCalculation.urgency(
          earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          latestFinish = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          now = ZonedDateTime.of(2023, 9, 28, 9, 59, 59, 0, londonTimezone),
          toDo = Duration.of(1, MINUTES)
        )
      )
    )
  }

  @Test
  fun testNowAfterLatestEndWithNothingToDo() {
    assertTrue(
      isTooLate(
        LinearlyIncreasingUrgencyCalculation.urgency(
          earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          latestFinish = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          now = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 1, londonTimezone),
          toDo = Duration.of(0, MINUTES)
        )
      )
    )
  }

  @Test
  fun testNowAfterLatestStart() {
    assertTrue(
      isTooLate(
        LinearlyIncreasingUrgencyCalculation.urgency(
          earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          latestFinish = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          now = ZonedDateTime.of(2023, 9, 28, 11, 29, 0, 1, londonTimezone),
          toDo = Duration.of(1, MINUTES)
        )
      )
    )
  }

  @Test
  fun testNowAtEarliestStart() {
    assertTrue(
      isMinimal(
        LinearlyIncreasingUrgencyCalculation.urgency(
          earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          latestFinish = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          now = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          toDo = Duration.of(1, MINUTES)
        )
      )
    )
  }

  @Test
  fun testNowAtLatestFinishWithNothingToDo() {
    assertTrue(
      isMaximal(
        LinearlyIncreasingUrgencyCalculation.urgency(
          earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          latestFinish = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          now = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          toDo = Duration.of(0, MINUTES)
        )
      )
    )
  }

  @Test
  fun testNowAtLatestStart() {
    assertTrue(
      isMaximal(
        LinearlyIncreasingUrgencyCalculation.urgency(
          earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          latestFinish = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          now = ZonedDateTime.of(2023, 9, 28, 11, 29, 0, 0, londonTimezone),
          toDo = Duration.of(1, MINUTES)
        )
      )
    )
  }

  @Test
  fun testNowBetweenEarliestStartAndLatestStart() {
    assertEquals(
      0.6,
      LinearlyIncreasingUrgencyCalculation.urgency(
        earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
        latestFinish = ZonedDateTime.of(2023, 9, 29, 16, 30, 0, 0, londonTimezone),
        now = ZonedDateTime.of(2023, 9, 29, 4, 0, 0, 0, londonTimezone),
        toDo = Duration.of(30, MINUTES)
      ),
      epsilon
    )
  }

  // TODO: This is not quite right. Can we even check this case?
  @Test
  fun testTooMuchToDoEvenBeforeStart() {
    assertTrue(
      isTooLate(
        LinearlyIncreasingUrgencyCalculation.urgency(
          earliestStart = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          latestFinish = ZonedDateTime.of(2023, 9, 28, 11, 30, 0, 0, londonTimezone),
          now = ZonedDateTime.of(2023, 9, 28, 10, 0, 0, 0, londonTimezone),
          toDo = Duration.of(2, HOURS)
        )
      )
    )
  }
}