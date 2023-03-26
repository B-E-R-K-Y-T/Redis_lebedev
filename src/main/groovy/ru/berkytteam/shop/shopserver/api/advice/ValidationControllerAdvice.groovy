package ru.berkytteam.shop.shopserver.api.advice

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.berkytteam.shop.shopserver.model.dto.InvalidRequestErrorDto

@RestControllerAdvice
class ValidationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    InvalidRequestErrorDto handleValidationExceptions(MethodArgumentNotValidException ex) {
        def errors = new HashMap<String, String>()
        ex.bindingResult.allErrors.forEach { FieldError error ->
            errors[error.field] = error.defaultMessage
        }

        return new InvalidRequestErrorDto(errors)
    }
}
