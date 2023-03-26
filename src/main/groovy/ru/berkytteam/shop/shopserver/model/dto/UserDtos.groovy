package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

abstract class BaseUserDto {
    @NotBlank
    @Schema(description = "Имя пользователя", example = "Тимофей Кондаков")
    String name

    @Email
    @NotBlank
    @Schema(description = "Адрес электронной почты пользователя", example = "username@service.domain")
    String email
}

@Schema(description = "Данные создания пользователя")
class UserCreateDto extends BaseUserDto{

}

@Schema(description = "Данные обновления пользователя")
class UserUpdateDto extends BaseUserDto{

}

@Schema(description = "Данные о пользователе")
class UserDto extends BaseUserDto {

    @Schema(description = "ID пользователя", example = "202b92a2-cb74-11ed-afa1-0242ac120002")
    UUID id
}