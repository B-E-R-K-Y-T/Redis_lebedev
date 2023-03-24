package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema

abstract class BaseOrderDto {
    UUID user
    @Schema(type = "number")
    BigInteger totalPrice
    Set<UUID> products
}

class OrderCreateDto extends BaseOrderDto{

}

class OrderUpdateDto extends BaseOrderDto{
    
}

class OrderDto extends BaseOrderDto {
    UUID id
}