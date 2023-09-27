package blip.webservice.exceptions

import jakarta.persistence.EntityExistsException
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@ResponseBody
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException::class)
  fun respondToConstraintViolationException(e: ConstraintViolationException): Map<String, String> =
    e.constraintViolations.associate { formatViolatedPropertyName(it) to formatViolationMessage(it) }

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(EntityExistsException::class)
  fun respondToEntityExistsException(e: EntityExistsException): String =
    e.localizedMessage

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(EntityNotFoundException::class)
  fun respondToEntityNotFoundException(e: EntityNotFoundException): String =
    e.localizedMessage

  private fun <T> formatViolatedPropertyName(constraintViolation: ConstraintViolation<T>): String =
    constraintViolation.propertyPath.last().toString()

  private fun <T> formatViolationMessage(constraintViolation: ConstraintViolation<T>): String =
    constraintViolation.message
}