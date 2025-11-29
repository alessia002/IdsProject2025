package it.unicam.cs.service;

import it.unicam.cs.dto.EventDTO;
import it.unicam.cs.enums.ParticipationStatus;
import it.unicam.cs.mapper.EventMapper;
import it.unicam.cs.model.Event;
import it.unicam.cs.model.EventParticipation;
import it.unicam.cs.model.MapPoint;
import it.unicam.cs.model.User;
import it.unicam.cs.repository.EventRepository;
import it.unicam.cs.repository.MapPointRepository;
import it.unicam.cs.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EventService {
    private final EventRepository repo;
    private final EventMapper mapper;
    private final UserRepository userRepository;
    private final MapPointRepository mapPointRepository;

    public EventDTO create(EventDTO dto) {
        MapPoint location = mapPointRepository.findById(dto.getLocationId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found with id " + dto.getLocationId()));
        Event event = mapper.toEntity(dto);
        event.setLocation(location);
        Event saved = repo.save(event);
        return mapper.toDTO(saved);
    }

    public EventDTO propose(Long id) {
        Event event = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));
        event.propose();
        repo.save(event);
        return mapper.toDTO(event);
    }

    public EventDTO confirm(Long id) {
        Event event = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));
        event.confirm();
        repo.save(event);
        return mapper.toDTO(event);
    }

    public EventDTO reject(Long id) {
        Event event = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));
        event.reject();
        repo.save(event);
        return mapper.toDTO(event);
    }

    public EventDTO update(Long id, EventDTO dto) {
        Event existingEvent = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));

        mapper.updateEntityFromDTO(dto, existingEvent);

        Event updated = repo.save(existingEvent);
        return mapper.toDTO(updated);
    }


    public EventDTO delete(Long id) {
        Event event = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));
        EventDTO dto = mapper.toDTO(event);
        repo.deleteById(id);
        return dto;
    }

    public EventDTO searchById(Long id) {
        return repo.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));
    }

    public List<EventDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public EventDTO invite(Long eventId, String username) {
        Event event = repo.findById(eventId).orElseThrow(() -> new EntityNotFoundException("Event not found with id " + eventId));
        User participant = userRepository.findById(username).orElseThrow(() -> new EntityNotFoundException("User not found with username " + username));
        EventParticipation eventParticipation = new EventParticipation();
        eventParticipation.setParticipant(participant);
        eventParticipation.setStatus(ParticipationStatus.PENDING);
        event.addParticipation(eventParticipation);

        repo.save(event);
        return mapper.toDTO(event);
    }
}
