package ru.berkytteam.shop.shopserver.model.dto

abstract class BaseCartDto {
    UUID user
    Set<UUID> products
}

class CartCreateDto extends BaseCartDto{

}

class CartUpdateDto extends BaseCartDto{

}

class CartDto extends BaseCartDto {
    UUID id
}