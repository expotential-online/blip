package blip.resource.agent

import blip.core.AgentName
import blip.core.CompleteUrl

data class AgentGetResponse(
  val name: AgentName,
  val agentTypeUrl: CompleteUrl
)
