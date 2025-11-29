package it.unicam.cs.dto;

import it.unicam.cs.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    private Long locationId;
    private List<EventParticipationDTO> participants;
    private EventStatus status;
    private String creationUserUsername;
}
