package blip.model.agent

import blip.model.Mapper

object AgentMapper : Mapper<AgentDto, Agent> {
  override fun toModel(dto: AgentDto): Agent = with(dto) {
    Agent(name)
  }
}