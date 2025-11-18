package it.unicam.cs.repository;

import it.unicam.cs.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByProduct_Id(Long productId);
    List<Review> findAllByCreationUser_Username(String username);
}

