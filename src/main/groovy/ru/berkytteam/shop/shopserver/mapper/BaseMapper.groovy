package ru.berkytteam.shop.shopserver.mapper

import org.mapstruct.MappingTarget

trait BaseMapper<Entity, CreateDto, UpdateDto, FullDto> {
    abstract FullDto toDto(Entity cart)
    abstract Entity createFromDto(CreateDto dto)
    abstract void updateFromDto(UpdateDto dto, @MappingTarget Entity entity)
}