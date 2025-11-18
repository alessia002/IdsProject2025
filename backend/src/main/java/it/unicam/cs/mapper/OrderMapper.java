package it.unicam.cs.mapper;

import it.unicam.cs.dto.OrderDTO;
import it.unicam.cs.model.Order;
import it.unicam.cs.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, PackageMapper.class  })
public interface OrderMapper {

    @Mapping(target = "creationUserUsername", source = "creationUser.username")
    OrderDTO toDTO(Order order);

    @Mapping(target = "creationUser", ignore = true)
    Order toEntity(OrderDTO dto);

    @AfterMapping
    default void setDerivedFields(@MappingTarget Order entity) {
        if (entity.getProducts() != null) {
            entity.setPrice(entity.getProducts().stream().mapToDouble(Product::getPrice).sum());
        } else {
            entity.setPrice(0);
        }
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    void updateEntityFromDTO(OrderDTO dto, @MappingTarget Order entity);
}
