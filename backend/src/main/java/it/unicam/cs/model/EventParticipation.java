package it.unicam.cs.model;

import it.unicam.cs.enums.ParticipationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "event_partecipation")
@NoArgsConstructor
@AllArgsConstructor
public class EventParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participant_username")
    private User participant;

    @Enumerated(EnumType.STRING)
    private ParticipationStatus status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public void accept() { this.status = ParticipationStatus.ACCEPTED; }
    public void reject() {
        this.status = ParticipationStatus.REJECTED;
    }
}
