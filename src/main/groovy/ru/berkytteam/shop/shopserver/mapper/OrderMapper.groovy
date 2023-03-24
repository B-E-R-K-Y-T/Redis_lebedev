package ru.berkytteam.shop.shopserver.mapper

import org.mapstruct.Mapper
import ru.berkytteam.shop.shopserver.model.dto.OrderCreateDto
import ru.berkytteam.shop.shopserver.model.dto.OrderDto
import ru.berkytteam.shop.shopserver.model.dto.OrderUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.Order

@Mapper(componentModel = "spring")
abstract class OrderMapper implements BaseMapper<Order, OrderCreateDto, OrderUpdateDto, OrderDto> {
}
