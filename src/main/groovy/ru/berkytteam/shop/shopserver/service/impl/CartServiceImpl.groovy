package ru.berkytteam.shop.shopserver.service.impl

import org.springframework.stereotype.Service
import ru.berkytteam.shop.shopserver.mapper.CartMapper
import ru.berkytteam.shop.shopserver.model.dto.CartCreateDto
import ru.berkytteam.shop.shopserver.model.dto.CartDto
import ru.berkytteam.shop.shopserver.model.dto.CartUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.Cart
import ru.berkytteam.shop.shopserver.repository.CartRepository
import ru.berkytteam.shop.shopserver.service.CartService

@Service
class CartServiceImpl implements BaseCrudServiceImpl<UUID, Cart, CartCreateDto, CartUpdateDto, CartDto, CartMapper, CartRepository>, CartService{
}
