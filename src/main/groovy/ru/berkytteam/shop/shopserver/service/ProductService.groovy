package ru.berkytteam.shop.shopserver.service

import ru.berkytteam.shop.shopserver.model.dto.ProductCreateDto
import ru.berkytteam.shop.shopserver.model.dto.ProductDto
import ru.berkytteam.shop.shopserver.model.dto.ProductUpdateDto

interface ProductService extends BaseCrudService<UUID, ProductCreateDto, ProductUpdateDto, ProductDto> {

}