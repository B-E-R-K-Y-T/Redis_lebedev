package ru.berkytteam.shop.shopserver.api.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.CartCreateDto
import ru.berkytteam.shop.shopserver.model.dto.CartDto
import ru.berkytteam.shop.shopserver.model.dto.CartUpdateDto
import ru.berkytteam.shop.shopserver.service.CartService

@Tag(name = "Работа с корзиной", description = "cart-controller")
@RequestMapping(path = "/api/v1/cart")
@RestController
class CartController {

    @Autowired
    CartService cartService

    @Operation(summary = "Получить корзину по ID")
    @GetMapping(path = "/{cartId}")
    ResponseEntity<CartDto> getCartById(@PathVariable UUID cartId) {
        return cartService.getById(cartId).toResponse()
    }

    @Operation(summary = "Создать новую корзину")
    @PostMapping
    ResponseEntity<CartDto> createCart(@RequestBody CartCreateDto createDto) {
        return cartService.create(createDto).toResponse()
    }

    @Operation(summary = "Обновить существующую корзину")
    @PutMapping(path = "/{cartId}")
    ResponseEntity<CartDto> updateCartById(@PathVariable UUID cartId, @RequestBody CartUpdateDto updateDto) {
        return cartService.updateById(cartId, updateDto).toResponse()
    }

    @Operation(summary = "Удалить существующую корзину")
    @DeleteMapping(path = "/{cartId}")
    ResponseEntity<CartDto> deleteCartById(@PathVariable UUID cartId) {
        return cartService.deleteById(cartId).toResponse()
    }
}
