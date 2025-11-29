package it.unicam.cs.service;

import it.unicam.cs.dto.EventParticipationDTO;
import it.unicam.cs.mapper.EventParticipationMapper;
import it.unicam.cs.model.EventParticipation;
import it.unicam.cs.repository.EventParticipationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EventParticipationService {
    private final EventParticipationRepository repo;
    private final EventParticipationMapper mapper;

    public EventParticipationDTO accept(Long id) {
        EventParticipation eventParticipation = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event participation not found with id " + id));
        eventParticipation.accept();
        repo.save(eventParticipation);
        return mapper.toDTO(eventParticipation);
    }

    public EventParticipationDTO reject(Long id) {
        EventParticipation eventParticipation = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event participation not found with id " + id));
        eventParticipation.reject();
        repo.save(eventParticipation);
        return mapper.toDTO(eventParticipation);
    }
}
