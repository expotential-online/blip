package blip.webservice.eventbus

interface EventChannel {
  fun id(): EventChannelId
}