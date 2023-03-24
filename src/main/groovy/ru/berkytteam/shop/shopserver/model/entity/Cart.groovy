package ru.berkytteam.shop.shopserver.model.entity


import org.springframework.data.redis.core.RedisHash

@RedisHash("carts")
class Cart {
    UUID id = UUID.randomUUID()
    UUID user
    Set<UUID> products
}
