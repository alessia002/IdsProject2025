package it.unicam.cs.mapper;

import it.unicam.cs.dto.ProductDTO;
import it.unicam.cs.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { ReviewMapper.class })
public interface ProductMapper {

    @Mapping(target = "creationUserUsername", source = "creationUser.username")
    ProductDTO toDTO(Product product);

    @Mapping(target = "creationUser", ignore = true)
    Product toEntity(ProductDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    void updateEntityFromDTO(ProductDTO dto, @MappingTarget Product entity);
}
