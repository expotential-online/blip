package blip.resource

import blip.core.CapitalisedSingularName
import blip.core.PluralisedUrlPart

enum class BlipResourceType(
  val capitalisedSingularName: CapitalisedSingularName,
  val pluralisedUrlPart: PluralisedUrlPart
) {
  AgentResource(
    "Agent",
    UrlParts.AgentResources
  ),
  AgentTypeResource(
    "Agent Type",
    UrlParts.AgentTypeResources
  ),
  BlipResource(
    "Blip",
    UrlParts.BlipResources
  ),
  ClientResource(
    "Client",
    UrlParts.ClientResources
  ),
  MeResource(
    "Me",
    UrlParts.MeResources
  ),
  PersonResource(
    "Person",
    UrlParts.PersonResources
  );

  object UrlParts {
    const val AgentResources = "agents"
    const val AgentTypeResources = "agent-types"
    const val ClientResources = "clients"
    const val BlipResources = "blips"
    const val MeResources = "me"
    const val PersonResources = "people"
  }
}