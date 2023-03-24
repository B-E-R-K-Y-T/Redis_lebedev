package ru.berkytteam.shop.shopserver.service

import ru.berkytteam.shop.shopserver.model.dto.OrderCreateDto
import ru.berkytteam.shop.shopserver.model.dto.OrderDto
import ru.berkytteam.shop.shopserver.model.dto.OrderUpdateDto

interface OrderService extends BaseCrudService<UUID, OrderCreateDto, OrderUpdateDto, OrderDto>{

}