package ru.berkytteam.shop.shopserver.model.dto

import io.swagger.v3.oas.annotations.media.Schema

import javax.validation.constraints.NotBlank

abstract class BaseProductDto {
    @NotBlank
    @Schema(description = "Название продукта", example = "Пылесос на колесиках")
    String name

    @NotBlank
    @Schema(description = "Описание продукта", example = "Сосет пыль и катается на колесиках")
    String description

    @Schema(description = "Стоимость продукта", type = "number", example = "10000")
    BigInteger price

    @NotBlank
    @Schema(description = "Ссылка на изображение товара", example = "https://my.images.hosting/image.jpg")
    String imageUrl
}

@Schema(description = "Данные для создания продукта")
class ProductCreateDto extends BaseProductDto{

}

@Schema(description = "Данные для обновления продукта")
class ProductUpdateDto extends BaseProductDto{

}

@Schema(description = "Данные о продукте")
class ProductDto extends BaseProductDto {

    @Schema(description = "ID продукта", example = "202b92a2-cb74-11ed-afa1-0242ac120002")
    UUID id
}