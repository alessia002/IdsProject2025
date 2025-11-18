package it.unicam.cs.mapper;

import it.unicam.cs.dto.PackageDTO;
import it.unicam.cs.model.Package;
import it.unicam.cs.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PackageMapper {

    @Mapping(target = "creationUserUsername", source = "creationUser.username")
    PackageDTO toDTO(Package Package);

    @Mapping(target = "creationUser", ignore = true)
    Package toEntity(PackageDTO dto);

    @AfterMapping
    default void setDerivedFields(@MappingTarget Package entity) {
        if (entity.getProductList() != null) {
            entity.setPrice(entity.getProductList().stream().mapToDouble(Product::getPrice).sum());
        } else {
            entity.setPrice(0);
        }
    }
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    void updateEntityFromDTO(PackageDTO dto, @MappingTarget Package entity);
}
