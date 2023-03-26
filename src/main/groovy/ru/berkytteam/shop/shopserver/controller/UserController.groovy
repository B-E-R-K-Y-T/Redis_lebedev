package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
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
    ResponseEntity<UserDto> getUserById(@PathVariable UUID userId) {
        return userService.getById(userId).toResponse()
    }

    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserCreateDto createDto) {
        return userService.create(createDto).toResponse()
    }

    @PutMapping(path = "/{userId}")
    ResponseEntity<UserDto> updateUserById(@PathVariable UUID userId, @RequestBody UserUpdateDto updateDto) {
        return userService.updateById(userId, updateDto).toResponse()
    }
    
    @DeleteMapping(path = "/{userId}")
    ResponseEntity<UserDto> deleteUserById(@PathVariable UUID userId) {
        return userService.deleteById(userId).toResponse()
    }
}
