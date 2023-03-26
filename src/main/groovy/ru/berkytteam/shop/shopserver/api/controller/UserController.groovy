package ru.berkytteam.shop.shopserver.api.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.UserCreateDto
import ru.berkytteam.shop.shopserver.model.dto.UserDto
import ru.berkytteam.shop.shopserver.model.dto.UserUpdateDto
import ru.berkytteam.shop.shopserver.service.UserService

import javax.validation.Valid

@Validated
@Tag(name = "Работа с пользователями", description = "user-controller")
@RequestMapping(path = "/api/v1/user")
@RestController
class UserController {

    @Autowired
    UserService userService

    @Operation(summary = "Получить существующего пользователя по ID")
    @GetMapping(path = "/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable UUID userId) {
        return userService.getById(userId).toResponse()
    }

    @Operation(summary = "Создать нового пользователя")
    @PostMapping
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateDto createDto) {
        return userService.create(createDto).toResponse()
    }


    @Operation(summary = "Обновить существующего пользователя")
    @PutMapping(path = "/{userId}")
    ResponseEntity<UserDto> updateUserById(@PathVariable UUID userId, @Valid @RequestBody UserUpdateDto updateDto) {
        return userService.updateById(userId, updateDto).toResponse()
    }


    @Operation(summary = "Удалить существующего пользователя")
    @DeleteMapping(path = "/{userId}")
    ResponseEntity<UserDto> deleteUserById(@PathVariable UUID userId) {
        return userService.deleteById(userId).toResponse()
    }
}
