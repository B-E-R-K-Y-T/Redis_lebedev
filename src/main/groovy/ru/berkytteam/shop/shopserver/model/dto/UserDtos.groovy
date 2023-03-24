package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema

abstract class BaseUserDto {
    String name
    String email
}

class UserCreateDto extends BaseUserDto{

}

@Schema
class UserUpdateDto extends BaseUserDto{

}

class UserDto extends BaseUserDto {
    UUID id
}