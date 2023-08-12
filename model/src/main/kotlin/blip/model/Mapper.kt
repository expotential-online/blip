package blip.model

interface Mapper<D, M> {
  fun toModel(dto: D): M
}