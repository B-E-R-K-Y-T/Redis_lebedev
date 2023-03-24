package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.UserCreateDto
import ru.berkytteam.shop.shopserver.model.dto.UserDto
import ru.berkytteam.shop.shopserver.model.dto.UserUpdateDto
import ru.berkytteam.shop.shopserver.service.UserService

@RequestMapping(path = "/api/v1/user")
@RestController
class UserController {

    @Autowired
    UserService userService

    @GetMapping(path = "/{userId}")
    Optional<UserDto> getUserById(@PathVariable UUID userId) {
        return userService.getById(userId)
    }

    @PostMapping
    UserDto createUser(@RequestBody UserCreateDto createDto) {
        return userService.create(createDto)
    }

    @PutMapping(path = "/{userId}")
    Optional<UserDto> updateUserById(@PathVariable UUID userId, @RequestBody UserUpdateDto updateDto) {
        return userService.updateById(userId, updateDto)
    }
    
    @DeleteMapping(path = "/{userId}")
    Optional<UserDto> deleteUserById(@PathVariable UUID userId) {
        return userService.deleteById(userId)
    }
}
