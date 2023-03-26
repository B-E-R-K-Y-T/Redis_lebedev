package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema

import javax.validation.constraints.NotEmpty

abstract class BaseOrderDto {
    @Schema(description = "ID пользователя, которому принадлежит заказ", example = "202b92a2-cb74-11ed-afa1-0242ac120002")
    UUID user

    @Schema(description = "Общая стоимость заказа", type = "number", example = "10000")
    BigInteger totalPrice

    @NotEmpty
    @Schema(description = "Список ID продуктов в заказе", example = '["202b92a2-cb74-11ed-afa1-0242ac120002"]')
    Set<UUID> products
}

@Schema(description = "Данные для создания заказа")
class OrderCreateDto extends BaseOrderDto{

}

@Schema(description = "Данные для обновления заказа")
class OrderUpdateDto extends BaseOrderDto{
    
}

@Schema(description = "Данные заказа")
class OrderDto extends BaseOrderDto {
    @Schema(description = "ID заказа", example = "202b92a2-cb74-11ed-afa1-0242ac120002")
    UUID id
}