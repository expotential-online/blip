package blip.webservice.eventbus

interface SubscribableEventBus {
  fun eventsForChannel(channelId: EventChannelId): EventFlux
}