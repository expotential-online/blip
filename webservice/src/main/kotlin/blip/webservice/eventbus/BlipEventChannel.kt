package blip.webservice.eventbus

enum class BlipEventChannel(private val id: EventChannelId) : EventChannel {
  AllAgentEventsChannel("all_agent_events"),
  AllAgentTypeEventsChannel("all_agent_type_events"),
  AllBlipEventsChannel("all_blip_events"),
  AllClientEventsChannel("all_client_events"),
  AllPersonEventsChannel("all_person_events");

  override fun id(): EventChannelId = id
}