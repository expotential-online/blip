package blip.webservice.exceptions

import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException

@ControllerAdvice
@ResponseBody
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException::class)
  fun respondToConstraintViolationException(e: ConstraintViolationException): Map<String, String> =
    e.constraintViolations.associate { formatViolatedPropertyName(it) to formatViolationMessage(it) }

  private fun <T> formatViolatedPropertyName(constraintViolation: ConstraintViolation<T>): String =
    constraintViolation.propertyPath.last().toString()

  private fun <T> formatViolationMessage(constraintViolation: ConstraintViolation<T>): String =
    constraintViolation.message
}