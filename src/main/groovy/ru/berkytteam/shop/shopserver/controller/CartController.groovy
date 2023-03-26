package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.CartCreateDto
import ru.berkytteam.shop.shopserver.model.dto.CartDto
import ru.berkytteam.shop.shopserver.model.dto.CartUpdateDto
import ru.berkytteam.shop.shopserver.service.CartService

@RequestMapping(path = "/api/v1/cart")
@RestController
class CartController {

    @Autowired
    CartService cartService

    @GetMapping(path = "/{cartId}")
    ResponseEntity<CartDto> getCartById(@PathVariable UUID cartId) {
        return cartService.getById(cartId).toResponse()
    }

    @PostMapping
    ResponseEntity<CartDto> createCart(@RequestBody CartCreateDto createDto) {
        return cartService.create(createDto).toResponse()
    }

    @PutMapping(path = "/{cartId}")
    ResponseEntity<CartDto> updateCartById(@PathVariable UUID cartId, @RequestBody CartUpdateDto updateDto) {
        return cartService.updateById(cartId, updateDto).toResponse()
    }

    @DeleteMapping(path = "/{cartId}")
    ResponseEntity<CartDto> deleteCartById(@PathVariable UUID cartId) {
        return cartService.deleteById(cartId).toResponse()
    }
}
