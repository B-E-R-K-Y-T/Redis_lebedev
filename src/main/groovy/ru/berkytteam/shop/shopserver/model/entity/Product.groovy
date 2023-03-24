package ru.berkytteam.shop.shopserver.model.entity


import org.springframework.data.redis.core.RedisHash

@RedisHash("products")
class Product {
    UUID id = UUID.randomUUID()
    String name
    String description
    BigInteger price
    String imageUrl
}
