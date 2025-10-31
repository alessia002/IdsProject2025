package it.unicam.cs.mapper;
import it.unicam.cs.dto.CatalogDTO;

import it.unicam.cs.model.Catalog;
import org.mapstruct.*;



@Mapper(componentModel ="spring")

public interface CatalogMapper {
    CatalogDTO toDTO(Catalog catalog);
    Catalog toEntity(CatalogDTO dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(CatalogDTO dto, @MappingTarget Catalog entity);
}
