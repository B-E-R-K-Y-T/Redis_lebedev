package ru.berkytteam.shop.shopserver.model.entity

import org.springframework.data.redis.core.RedisHash

@RedisHash("orders")
class Order {
    UUID id = UUID.randomUUID()
    UUID user
    BigInteger totalPrice
    Set<UUID> products
}
