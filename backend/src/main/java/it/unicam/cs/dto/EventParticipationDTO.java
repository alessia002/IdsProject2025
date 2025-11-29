package it.unicam.cs.dto;

import it.unicam.cs.enums.ParticipationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventParticipationDTO {
    private Long id;
    private String participantUsername;
    private ParticipationStatus status;
    private Long eventId;
}
