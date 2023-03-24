package ru.berkytteam.shop.shopserver.service


import org.springframework.web.bind.annotation.RequestBody

interface BaseCrudService<EntityId, CreateDto, UpdateDto, FullDto> {
    Optional<FullDto> getById(EntityId id)
    FullDto create(@RequestBody CreateDto createDto)
    Optional<FullDto> updateById(EntityId entityId, UpdateDto updateDto)
    Optional<FullDto> deleteById(EntityId entityId)
}
