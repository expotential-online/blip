package blip.webservice.service

interface ModelService<M : Any, I : Any, D : Any> {
  fun register(dto: D): M
  fun view(id: I): M
}