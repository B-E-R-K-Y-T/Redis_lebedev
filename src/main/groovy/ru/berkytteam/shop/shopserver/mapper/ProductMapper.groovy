package ru.berkytteam.shop.shopserver.mapper

import org.mapstruct.Mapper
import ru.berkytteam.shop.shopserver.model.dto.ProductCreateDto
import ru.berkytteam.shop.shopserver.model.dto.ProductDto
import ru.berkytteam.shop.shopserver.model.dto.ProductUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.Product

@Mapper(componentModel = "spring")
abstract class ProductMapper implements BaseMapper<Product, ProductCreateDto, ProductUpdateDto, ProductDto> {
}
