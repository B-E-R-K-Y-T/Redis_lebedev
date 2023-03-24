package ru.berkytteam.shop.shopserver.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.RequestBody
import ru.berkytteam.shop.shopserver.mapper.BaseMapper

trait BaseCrudServiceImpl<EntityId, Entity, CreateDto, UpdateDto, FullDto, Mapper extends BaseMapper<Entity, CreateDto, UpdateDto, FullDto>, EntityRepo extends CrudRepository<Entity, EntityId>> {
    @Autowired
    EntityRepo repository

    @Autowired
    Mapper mapper

    Optional<FullDto> getById(EntityId id) {
        return repository.findById(id).map(mapper::toDto)
    }

    FullDto create(@RequestBody CreateDto createDto) {
        def cart = mapper.createFromDto(createDto)
        repository.save(cart)
        return mapper.toDto(cart)
    }

    Optional<FullDto> updateById(EntityId entityId, UpdateDto updateDto) {
        return repository.findById(entityId)
            .map {
                mapper.updateFromDto(updateDto, it)
                mapper.toDto(it)
            }
    }

    Optional<FullDto> deleteById(EntityId entityId) {
        return repository.findById(entityId)
            .map {
                repository.delete(it)
                mapper.toDto(it)
            }
    }
}