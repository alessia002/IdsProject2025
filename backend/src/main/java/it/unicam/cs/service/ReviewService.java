package it.unicam.cs.service;

import it.unicam.cs.dto.ReviewDTO;
import it.unicam.cs.mapper.ReviewMapper;
import it.unicam.cs.model.Product;
import it.unicam.cs.model.Review;
import it.unicam.cs.model.User;
import it.unicam.cs.repository.ProductRepository;
import it.unicam.cs.repository.ReviewRepository;
import it.unicam.cs.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository repo;
    private final ProductRepository productRepository;
    private final ReviewMapper mapper;
    private final UserRepository userRepository;

    public ReviewDTO create(ReviewDTO dto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + username));
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + dto.getProductId()));
        Review review = mapper.toEntity(dto);
        review.setProduct(product);
        review.setCreationUser(currentUser);
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
        ReviewDTO dto = mapper.toDTO(review);
        repo.deleteById(id);
        return dto;
    }

    public ReviewDTO searchById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow();
    }

    public List<ReviewDTO> searchByProduct(Long productId) {
        return repo.findAllByProduct_Id(productId).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public List<ReviewDTO> searchByUser(String username) {
        return repo.findAllByCreationUser_Username(username).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public List<ReviewDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}