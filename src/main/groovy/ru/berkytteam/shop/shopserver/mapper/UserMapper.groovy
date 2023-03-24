package ru.berkytteam.shop.shopserver.mapper

import org.mapstruct.Mapper
import ru.berkytteam.shop.shopserver.model.dto.UserCreateDto
import ru.berkytteam.shop.shopserver.model.dto.UserDto
import ru.berkytteam.shop.shopserver.model.dto.UserUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.User

@Mapper(componentModel = "spring")
abstract class UserMapper implements BaseMapper<User, UserCreateDto, UserUpdateDto, UserDto> {
}
