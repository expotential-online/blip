package blip.webservice.service

import blip.model.Mapper
import org.springframework.data.jpa.repository.JpaRepository
import javax.validation.ConstraintViolationException
import javax.validation.Validation.buildDefaultValidatorFactory
import javax.validation.Validator

abstract class AbstractModelService<M : Any, I : Any, D : Any>(
  private val repo: JpaRepository<M, I>,
  private val mapper: Mapper<D, M>
) : ModelService<M, I, D> {

  private val validator: Validator = buildDefaultValidatorFactory().validator

  override fun register(dto: D): M {
    validateAndMaybeThrow(dto)
    val model = mapper.toModel(dto)
    return repo.save(model)
  }

  override fun view(id: I): M {
    return repo.getById(id)
  }

  private fun validateAndMaybeThrow(dto: D) {
    val constraintViolations = validator.validate(dto)
    if (constraintViolations.isNotEmpty()) {
      throw ConstraintViolationException(constraintViolations)
    }
  }
}