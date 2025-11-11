package it.unicam.cs.model;

import it.unicam.cs.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name= "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String category;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public void unpublish() {
        this.status = ProductStatus.DRAFT;
    }
    public void publish() {
        this.status = ProductStatus.PUBLISHED;
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }
}

