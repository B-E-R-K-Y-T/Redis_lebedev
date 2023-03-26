package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.OrderCreateDto
import ru.berkytteam.shop.shopserver.model.dto.OrderDto
import ru.berkytteam.shop.shopserver.model.dto.OrderUpdateDto
import ru.berkytteam.shop.shopserver.service.OrderService

@RequestMapping(path = "/api/v1/order")
@RestController
class OrderController {

    @Autowired
    OrderService orderService

    @GetMapping(path = "/{orderId}")
    ResponseEntity<OrderDto> getOrderById(@PathVariable UUID orderId) {
        return orderService.getById(orderId).toResponse()
    }

    @PostMapping
    ResponseEntity<OrderDto> createOrder(@RequestBody OrderCreateDto createDto) {
        return orderService.create(createDto).toResponse()
    }

    @PutMapping(path = "/{orderId}")
    ResponseEntity<OrderDto> updateOrderById(@PathVariable UUID orderId, @RequestBody OrderUpdateDto updateDto) {
        return orderService.updateById(orderId, updateDto).toResponse()
    }
    
    @DeleteMapping(path = "/{orderId}")
    ResponseEntity<OrderDto> deleteOrderById(@PathVariable UUID orderId) {
        return orderService.deleteById(orderId).toResponse()
    }
}
