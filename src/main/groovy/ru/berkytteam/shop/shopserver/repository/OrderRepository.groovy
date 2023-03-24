package ru.berkytteam.shop.shopserver.repository


import org.springframework.data.repository.CrudRepository
import ru.berkytteam.shop.shopserver.model.entity.Order

interface OrderRepository extends CrudRepository<Order, UUID> {

}