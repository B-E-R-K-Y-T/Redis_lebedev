package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.ProductCreateDto
import ru.berkytteam.shop.shopserver.model.dto.ProductDto
import ru.berkytteam.shop.shopserver.model.dto.ProductUpdateDto
import ru.berkytteam.shop.shopserver.service.ProductService

@RequestMapping(path = "/api/v1/product")
@RestController
class ProductController {

    @Autowired
    ProductService productService

    @GetMapping(path = "/{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable UUID productId) {
        return productService.getById(productId).toResponse()
    }

    @PostMapping
    ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateDto createDto) {
        return productService.create(createDto).toResponse()
    }

    @PutMapping(path = "/{productId}")
    ResponseEntity<ProductDto> updateProductById(@PathVariable UUID productId, @RequestBody ProductUpdateDto updateDto) {
        return productService.updateById(productId, updateDto).toResponse()
    }
    
    @DeleteMapping(path = "/{productId}")
    ResponseEntity<ProductDto> deleteProductById(@PathVariable UUID productId) {
        return productService.deleteById(productId).toResponse()
    }
}
