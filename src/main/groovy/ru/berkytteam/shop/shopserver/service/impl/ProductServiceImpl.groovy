package ru.berkytteam.shop.shopserver.service.impl

import org.springframework.stereotype.Service
import ru.berkytteam.shop.shopserver.mapper.ProductMapper
import ru.berkytteam.shop.shopserver.model.dto.ProductCreateDto
import ru.berkytteam.shop.shopserver.model.dto.ProductDto
import ru.berkytteam.shop.shopserver.model.dto.ProductUpdateDto
import ru.berkytteam.shop.shopserver.model.entity.Product
import ru.berkytteam.shop.shopserver.repository.ProductRepository
import ru.berkytteam.shop.shopserver.service.ProductService

@Service
class ProductServiceImpl implements BaseCrudServiceImpl<UUID, Product, ProductCreateDto, ProductUpdateDto, ProductDto, ProductMapper, ProductRepository>, ProductService {
}
