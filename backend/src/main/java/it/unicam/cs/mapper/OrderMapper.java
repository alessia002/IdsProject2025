package it.unicam.cs.mapper;

import it.unicam.cs.dto.OrderDTO;
import it.unicam.cs.model.Order;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface OrderMapper {
    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(OrderDTO dto, @MappingTarget Order entity);
}
