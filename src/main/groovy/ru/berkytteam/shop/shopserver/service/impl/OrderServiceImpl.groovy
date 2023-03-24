package ru.berkytteam.shop.shopserver.service.impl

import org.springframework.stereotype.Service
import ru.berkytteam.shop.shopserver.mapper.OrderMapper
import ru.berkytteam.shop.shopserver.model.dto.OrderCreateDto
import ru.berkytteam.shop.shopserver.model.dto.OrderDto
import ru.berkytteam.shop.shopserver.model.dto.OrderUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.Order
import ru.berkytteam.shop.shopserver.repository.OrderRepository
import ru.berkytteam.shop.shopserver.service.OrderService

@Service
class OrderServiceImpl implements BaseCrudServiceImpl<UUID, Order, OrderCreateDto, OrderUpdateDto, OrderDto, OrderMapper, OrderRepository>, OrderService{

}
