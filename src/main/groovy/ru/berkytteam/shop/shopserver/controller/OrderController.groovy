package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.OrderCreateDto
import ru.berkytteam.shop.shopserver.model.dto.OrderDto
import ru.berkytteam.shop.shopserver.model.dto.OrderUpdateDto
import ru.berkytteam.shop.shopserver.service.OrderService

import static ru.berkytteam.shop.shopserver.controller.ApiConstants.API_V1

@RequestMapping(path = "/api/v1/order")
@RestController
class OrderController {

    @Autowired
    OrderService orderService

    @GetMapping(path = "/{orderId}")
    Optional<OrderDto> getOrderById(@PathVariable UUID orderId) {
        return orderService.getById(orderId)
    }

    @PostMapping
    OrderDto createOrder(@RequestBody OrderCreateDto createDto) {
        return orderService.create(createDto)
    }

    @PutMapping(path = "/{orderId}")
    Optional<OrderDto> updateOrderById(@PathVariable UUID orderId, @RequestBody OrderUpdateDto updateDto) {
        return orderService.updateById(orderId, updateDto)
    }
    
    @DeleteMapping(path = "/{orderId}")
    Optional<OrderDto> deleteOrderById(@PathVariable UUID orderId) {
        return orderService.deleteById(orderId)
    }
}
