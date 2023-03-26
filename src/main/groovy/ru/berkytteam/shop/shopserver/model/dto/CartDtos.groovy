package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema

import javax.validation.constraints.NotNull

abstract class BaseCartDto {

    @NotNull
    @Schema(description = "ID пользователя, которому принадлежит корзина", example = "202b92a2-cb74-11ed-afa1-0242ac120002")
    UUID user

    @NotNull
    @Schema(description = "Список ID продуктов в корзине", example = '["202b92a2-cb74-11ed-afa1-0242ac120002"]')
    Set<UUID> products
}

@Schema(description = "Данные для создания корзины")
class CartCreateDto extends BaseCartDto{

}

@Schema(description = "Данные для обновления корзины")
class CartUpdateDto extends BaseCartDto{

}

@Schema(description = "Данные корзины")
class CartDto extends BaseCartDto {

    @Schema(description = "ID корзины", example = "202b92a2-cb74-11ed-afa1-0242ac120002")
    UUID id
}