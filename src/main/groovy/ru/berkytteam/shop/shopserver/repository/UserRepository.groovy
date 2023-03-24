package ru.berkytteam.shop.shopserver.repository

import org.springframework.data.repository.CrudRepository
import ru.berkytteam.shop.shopserver.model.entity.User

interface UserRepository extends CrudRepository<User, UUID>{

}