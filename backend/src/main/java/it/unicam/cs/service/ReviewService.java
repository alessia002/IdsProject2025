package it.unicam.cs.service;

import it.unicam.cs.dto.ReviewDTO;
import it.unicam.cs.mapper.ReviewMapper;
import it.unicam.cs.model.Review;
import it.unicam.cs.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository repo;
    private final ReviewMapper mapper;

    public ReviewDTO create(ReviewDTO dto) {
        Review review = mapper.toEntity(dto);
        Review saved = repo.save(review);
        return mapper.toDTO(saved);
    }

    public ReviewDTO update(Long id, ReviewDTO dto) {
        Review existingReview = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id " + id));

        mapper.updateEntityFromDTO(dto, existingReview);

        Review updated = repo.save(existingReview);
        return mapper.toDTO(updated);
    }

    public ReviewDTO delete(Long id) {
        Review review = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id " + id));
        repo.deleteById(id);
        return mapper.toDTO(review);
    }

    public ReviewDTO searchById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow();
    }

    public List<ReviewDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}