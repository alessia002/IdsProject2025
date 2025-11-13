package it.unicam.cs.mapper;

import it.unicam.cs.dto.ReviewDTO;
import it.unicam.cs.model.Review;
import org.mapstruct.*;

@Mapper(componentModel ="spring")
public interface ReviewMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "creationUserUsername", source = "creationUser.username")
    ReviewDTO toDTO(Review Review);

    @Mapping(target = "product", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    Review toEntity(ReviewDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    void updateEntityFromDTO(ReviewDTO dto, @MappingTarget Review entity);
}
