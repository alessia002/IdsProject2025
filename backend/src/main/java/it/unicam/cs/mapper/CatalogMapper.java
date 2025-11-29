package it.unicam.cs.mapper;

import it.unicam.cs.dto.CatalogDTO;
import it.unicam.cs.model.Catalog;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, PackageMapper.class })
public interface CatalogMapper {

    @Mapping(target = "creationUserUsername", source = "creationUser.username")
    @Mapping(target = "packageList", ignore = true)
    @Mapping(target = "productList", ignore = true)
    CatalogDTO toDTO(Catalog catalog);

    @Mapping(target = "creationUser", ignore = true)
    @Mapping(target = "packageList", ignore = true)
    @Mapping(target = "productList", ignore = true)
    Catalog toEntity(CatalogDTO dto);

    @AfterMapping
    default void setDerivedFields(@MappingTarget Catalog entity) {
        if (entity.getProductList() != null) {
            entity.setNumProduct(entity.getProductList().size());
        } else {
            entity.setNumProduct(0);
        }
    }
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    @Mapping(target = "packageList", ignore = true)
    @Mapping(target = "productList", ignore = true)
    void updateEntityFromDTO(CatalogDTO dto, @MappingTarget Catalog entity);
}
