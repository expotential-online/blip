package blip.model.blip

import blip.model.Mapper

object BlipMapper : Mapper<BlipDto, Blip> {
  override fun toModel(dto: BlipDto): Blip = with(dto) {
    Blip(summary)
  }
}