package ru.berkytteam.shop.shopserver.api.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.OrderCreateDto
import ru.berkytteam.shop.shopserver.model.dto.OrderDto
import ru.berkytteam.shop.shopserver.model.dto.OrderUpdateDto
import ru.berkytteam.shop.shopserver.service.OrderService

import javax.validation.Valid

@Tag(name = "Работа с заказами", description = "order-controller")
@RequestMapping(path = "/api/v1/order")
@RestController
class OrderController {

    @Autowired
    OrderService orderService

    @Operation(summary = "Получить заказ по ID")
    @GetMapping(path = "/{orderId}")
    ResponseEntity<OrderDto> getOrderById(@PathVariable UUID orderId) {
        return orderService.getById(orderId).toResponse()
    }

    @Operation(summary = "Создать новый заказ")
    @PostMapping
    ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderCreateDto createDto) {
        return orderService.create(createDto).toResponse()
    }

    @Operation(summary = "Обновить существующий заказ")
    @PutMapping(path = "/{orderId}")
    ResponseEntity<OrderDto> updateOrderById(@PathVariable UUID orderId, @Valid @RequestBody OrderUpdateDto updateDto) {
        return orderService.updateById(orderId, updateDto).toResponse()
    }

    @Operation(summary = "Удалить существующий заказ")
    @DeleteMapping(path = "/{orderId}")
    ResponseEntity<OrderDto> deleteOrderById(@PathVariable UUID orderId) {
        return orderService.deleteById(orderId).toResponse()
    }
}
