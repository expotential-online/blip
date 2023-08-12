package blip.webservice.service

import blip.model.Mapper
import org.springframework.data.jpa.repository.JpaRepository
import javax.validation.Validator

class DefaultServiceDelegate<D : Any, M : Any, I : Any>(
  private val mapper: Mapper<D, M>,
  private val validator: Validator,
  private val repo: JpaRepository<M, I>
) : ServiceDelegate<D, M, I> {

  override fun register(dto: D): M {
    validator.validate(dto)
    val model = mapper.toModel(dto)
    return repo.save(model)
  }

  override fun view(id: I): M {
    return repo.getById(id)
  }
}