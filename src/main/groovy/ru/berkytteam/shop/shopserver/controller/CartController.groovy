package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
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
    Optional<CartDto> getCartById(@PathVariable UUID cartId) {
        return cartService.getById(cartId)
    }

    @PostMapping
    CartDto createCart(@RequestBody CartCreateDto createDto) {
        return cartService.create(createDto)
    }

    @PutMapping(path = "/{cartId}")
    Optional<CartDto> updateCartById(@PathVariable UUID cartId, @RequestBody CartUpdateDto updateDto) {
        return cartService.updateById(cartId, updateDto)
    }

    @DeleteMapping(path = "/{cartId}")
    Optional<CartDto> deleteCartById(@PathVariable UUID cartId) {
        return cartService.deleteById(cartId)
    }
}
