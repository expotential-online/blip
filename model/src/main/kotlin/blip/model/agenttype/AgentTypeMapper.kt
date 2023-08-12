package blip.model.agenttype

import blip.model.Mapper

object AgentTypeMapper : Mapper<AgentTypeDto, AgentType> {
  override fun toModel(dto: AgentTypeDto): AgentType = with(dto) {
    AgentType(name)
  }
}