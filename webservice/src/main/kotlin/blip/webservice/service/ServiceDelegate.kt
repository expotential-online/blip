package blip.webservice.service

interface ServiceDelegate<D : Any, M : Any, I : Any> {
  fun register(dto: D): M
  fun view(id: I): M
}