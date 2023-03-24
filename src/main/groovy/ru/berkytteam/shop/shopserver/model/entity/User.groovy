package ru.berkytteam.shop.shopserver.model.entity


import org.springframework.data.redis.core.RedisHash

@RedisHash("users")
class User {
    UUID id = UUID.randomUUID()
    String name
    String email
}
