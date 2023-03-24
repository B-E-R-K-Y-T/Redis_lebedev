package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema

abstract class BaseProductDto {
    String name
    String description
    @Schema(type = "number")
    BigInteger price
    String imageUrl
}

class ProductCreateDto extends BaseProductDto{

}

class ProductUpdateDto extends BaseProductDto{

}

class ProductDto extends BaseProductDto {
    UUID id
}