package blip.webservice.eventbus

import blip.core.event.Event
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.Many

@Service
class InProcessEventBusService : PublishableEventBus, SubscribableEventBus {

  private val logger = LoggerFactory.getLogger(javaClass)
  private val sinksByChannel = mutableMapOf<EventChannelId, EventSink>()

  override fun publishEventToChannel(channelId: EventChannelId, event: Event) {
    sinkCreatingIfNecessary(channelId).tryEmitNext(event)
  }

  override fun publishEventToChannel(channel: EventChannel, event: Event) {
    publishEventToChannel(channel.id(), event)
  }

  override fun eventsForChannel(channelId: EventChannelId): EventFlux =
    sinkCreatingIfNecessary(channelId).asFlux()

  private fun sinkCreatingIfNecessary(channelId: EventChannelId): EventSink =
    sinksByChannel.computeIfAbsent(channelId, this::createSink)

  private fun createSink(channelId: EventChannelId): Many<Event> {
    logger.info("Creating sink for event channel ID [$channelId]")
    return Sinks.many().multicast().directBestEffort()
  }
}