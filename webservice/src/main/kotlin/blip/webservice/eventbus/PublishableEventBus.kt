package blip.webservice.eventbus

import blip.core.event.Event

interface PublishableEventBus {
  fun publishEventToChannel(channelId: EventChannelId, event: Event)
  fun publishEventToChannel(channel: EventChannel, event: Event)
}