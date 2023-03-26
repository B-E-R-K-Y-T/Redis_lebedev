package ru.berkytteam.shop.shopserver.api.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.ProductCreateDto
import ru.berkytteam.shop.shopserver.model.dto.ProductDto
import ru.berkytteam.shop.shopserver.model.dto.ProductUpdateDto
import ru.berkytteam.shop.shopserver.service.ProductService

import javax.validation.Valid

@Tag(name = "Работа с товарами", description = "product-controller")
@RequestMapping(path = "/api/v1/product")
@RestController
class ProductController {

    @Autowired
    ProductService productService

    @Operation(summary = "Получить товар по ID")
    @GetMapping(path = "/{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable UUID productId) {
        return productService.getById(productId).toResponse()
    }

    @Operation(summary = "Создать новый товар")
    @PostMapping
    ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductCreateDto createDto) {
        return productService.create(createDto).toResponse()
    }

    @Operation(summary = "Обновить существующий товар")
    @PutMapping(path = "/{productId}")
    ResponseEntity<ProductDto> updateProductById(@PathVariable UUID productId, @RequestBody @Valid ProductUpdateDto updateDto) {
        return productService.updateById(productId, updateDto).toResponse()
    }

    @Operation(summary = "Удалить существующий товар")
    @DeleteMapping(path = "/{productId}")
    ResponseEntity<ProductDto> deleteProductById(@PathVariable UUID productId) {
        return productService.deleteById(productId).toResponse()
    }
}
