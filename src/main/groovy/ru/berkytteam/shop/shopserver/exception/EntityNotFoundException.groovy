package ru.berkytteam.shop.shopserver.exception

class EntityNotFoundException extends RuntimeException {
    Class<?> entityType
    String condition

    EntityNotFoundException(Class<?> entityType, String condition) {
        this.entityType = entityType
        this.condition = condition
    }
}
