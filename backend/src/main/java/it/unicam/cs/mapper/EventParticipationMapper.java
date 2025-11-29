package it.unicam.cs.mapper;

import it.unicam.cs.dto.EventParticipationDTO;
import it.unicam.cs.model.EventParticipation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventParticipationMapper {

    @Mapping(target = "participantUsername", source = "participant.username")
    @Mapping(target = "eventId", source = "event.id")
    EventParticipationDTO toDTO(EventParticipation entity);

    @Mapping(target = "participant", ignore = true)
    @Mapping(target = "event", ignore = true)
    EventParticipation toEntity(EventParticipationDTO dto);
}
