package blip.webservice.eventbus

import blip.core.event.Event
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EventBus {

  private val logger = LoggerFactory.getLogger(javaClass)

  fun <E : Event> postEvent(event: E) {
    logger.info("Posted event: $event")
  }
}