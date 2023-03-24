package ru.berkytteam.shop.shopserver.service

import ru.berkytteam.shop.shopserver.model.dto.UserCreateDto
import ru.berkytteam.shop.shopserver.model.dto.UserDto
import ru.berkytteam.shop.shopserver.model.dto.UserUpdateDto

interface UserService extends BaseCrudService<UUID, UserCreateDto, UserUpdateDto, UserDto>{

}