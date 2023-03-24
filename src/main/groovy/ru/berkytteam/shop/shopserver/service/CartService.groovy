package ru.berkytteam.shop.shopserver.service

import ru.berkytteam.shop.shopserver.model.dto.CartCreateDto
import ru.berkytteam.shop.shopserver.model.dto.CartDto
import ru.berkytteam.shop.shopserver.model.dto.CartUpdateDto

interface CartService extends BaseCrudService<UUID, CartCreateDto, CartUpdateDto, CartDto> {

}