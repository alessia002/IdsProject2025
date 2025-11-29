package it.unicam.cs.model;

import it.unicam.cs.enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name= "event")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private MapPoint location;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventParticipation> participants = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @ManyToOne
    @JoinColumn(name = "creation_user_username")
    private User creationUser;

    public void propose(){
        this.status = EventStatus.PROPOSAL;
    }
    public void confirm(){
        this.status = EventStatus.CONFIRMED;
    }
    public void reject(){
        this.status = EventStatus.REJECTED;
    }

    public void addParticipation(EventParticipation eventParticipation) {
        this.participants.add(eventParticipation);
        eventParticipation.setEvent(this);
    }
}
