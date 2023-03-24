package ru.berkytteam.shop.shopserver.service.impl

import org.springframework.stereotype.Service
import ru.berkytteam.shop.shopserver.mapper.UserMapper
import ru.berkytteam.shop.shopserver.model.dto.UserCreateDto
import ru.berkytteam.shop.shopserver.model.dto.UserDto
import ru.berkytteam.shop.shopserver.model.dto.UserUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.User
import ru.berkytteam.shop.shopserver.repository.UserRepository
import ru.berkytteam.shop.shopserver.service.UserService

@Service
class UserServiceImpl implements BaseCrudServiceImpl<UUID, User, UserCreateDto, UserUpdateDto, UserDto, UserMapper, UserRepository>, UserService {
}
