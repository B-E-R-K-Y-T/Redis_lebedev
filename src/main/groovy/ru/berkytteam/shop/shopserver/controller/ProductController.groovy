package ru.berkytteam.shop.shopserver.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.berkytteam.shop.shopserver.model.dto.ProductCreateDto
import ru.berkytteam.shop.shopserver.model.dto.ProductDto
import ru.berkytteam.shop.shopserver.model.dto.ProductUpdateDto
import ru.berkytteam.shop.shopserver.service.ProductService

import static ru.berkytteam.shop.shopserver.controller.ApiConstants.API_V1

@RequestMapping(path = "/api/v1/product")
@RestController
class ProductController {

    @Autowired
    ProductService productService

    @GetMapping(path = "/{productId}")
    Optional<ProductDto> getProductById(@PathVariable UUID productId) {
        return productService.getById(productId)
    }

    @PostMapping
    ProductDto createProduct(@RequestBody ProductCreateDto createDto) {
        return productService.create(createDto)
    }

    @PutMapping(path = "/{productId}")
    Optional<ProductDto> updateProductById(@PathVariable UUID productId, @RequestBody ProductUpdateDto updateDto) {
        return productService.updateById(productId, updateDto)
    }
    
    @DeleteMapping(path = "/{productId}")
    Optional<ProductDto> deleteProductById(@PathVariable UUID productId) {
        return productService.deleteById(productId)
    }
}
