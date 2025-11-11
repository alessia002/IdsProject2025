package it.unicam.cs.mapper;


import it.unicam.cs.dto.PackageDTO;
import it.unicam.cs.model.Package;
import it.unicam.cs.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PackageMapper {
    PackageDTO toDTO(Package Package);
    Package toEntity(PackageDTO dto);
    @AfterMapping
    default void setDerivedFields(@MappingTarget Package entity) {
        if (entity.getProductList() != null) {
            entity.setTotal(entity.getProductList().stream().mapToDouble(Product::getPrice).sum());
        } else {
            entity.setTotal(null);
        }
    }
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(PackageDTO dto, @MappingTarget Package entity);
}
