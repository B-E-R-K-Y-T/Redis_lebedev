package ru.berkytteam.shop.shopserver.mapper

import org.mapstruct.Mapper
import ru.berkytteam.shop.shopserver.model.dto.CartCreateDto
import ru.berkytteam.shop.shopserver.model.dto.CartDto
import ru.berkytteam.shop.shopserver.model.dto.CartUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.Cart

@Mapper(componentModel = "spring")
abstract class CartMapper implements BaseMapper<Cart, CartCreateDto, CartUpdateDto, CartDto> {

}
