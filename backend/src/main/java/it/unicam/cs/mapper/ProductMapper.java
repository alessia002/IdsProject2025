package it.unicam.cs.mapper;

import it.unicam.cs.dto.ProductDTO;
import it.unicam.cs.model.Product;
import org.mapstruct.*;

@Mapper(componentModel ="spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ProductDTO dto, @MappingTarget Product entity);
}
