package ru.berkytteam.shop.shopserver.api.advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.berkytteam.shop.shopserver.exception.EntityNotFoundException
import ru.berkytteam.shop.shopserver.model.dto.HttpErrorDto

@RestControllerAdvice
class EntityNotFoundControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    HttpErrorDto handleValidationExceptions(EntityNotFoundException ex) {
        return new HttpErrorDto(
                status: HttpStatus.NOT_FOUND,
                message: "Can't resolve entity '${ex.entityType.simpleName}' with ${ex.condition}. Is it invalid?"
        )
    }
}
