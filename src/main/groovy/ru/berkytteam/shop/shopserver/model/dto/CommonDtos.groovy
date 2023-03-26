package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus

@Schema(description = "Информация об ошибке")
class HttpErrorDto {
    @Schema(description = "Пояснение к ошибке", example = "Internal server error")
    String message

    @Schema(description = "HTTP статус ошибки", example = "INTERNAL_SERVER_ERROR")
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR
}

@Schema(description = "Информация о неверном запросе")
class InvalidRequestErrorDto extends HttpErrorDto {

    @Schema(
            description = "Описание ошибок валидации запроса",
            example = """
                         {
                            "name": "значение не должно быть пустым!",
                            "email": "значение должно быть корректным email!"
                         }
                      """
    )
    Map<String, String> validationErrors

    InvalidRequestErrorDto(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors
        this.message = "Got invalid request data"
        this.status = HttpStatus.BAD_REQUEST
    }
}
