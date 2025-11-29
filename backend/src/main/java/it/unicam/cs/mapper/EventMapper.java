package it.unicam.cs.mapper;

import it.unicam.cs.dto.EventDTO;
import it.unicam.cs.model.Event;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { EventParticipationMapper.class})
public interface EventMapper {

    @Mapping(target = "creationUserUsername", source = "creationUser.username")
    @Mapping(target = "locationId", source = "location.id")
    EventDTO toDTO(Event entity);

    @Mapping(target = "creationUser", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "participants", ignore = true)
    Event toEntity(EventDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "participants", ignore = true)
    void updateEntityFromDTO(EventDTO dto, @MappingTarget Event entity);
}
