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
    private String description;
    private double price;
    private String category;
    private int stock;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;
    @ManyToOne
    @JoinColumn(name = "creation_user_username")
    private User creationUser;

    public void unpublish() {
        this.status = ProductStatus.DRAFT;
    }
    public void publish() {
        this.status = ProductStatus.VALIDATING;
    }
    public void validate() {this.status = ProductStatus.PUBLISHED;}

    @Override
    public void addReview(Review review) {
        if(review == null){
            throw new IllegalArgumentException("Review must not be null");
        }
        if(status != ProductStatus.PUBLISHED){
            throw new IllegalArgumentException("Product is not published");
        }
        reviews.add(review);}

    public int removeFromStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (quantity > stock) {
            throw new IllegalArgumentException("Quantity exceeds stock");
        }
        this.stock -= quantity;
        if (this.stock == 0) this.status = ProductStatus.OUT_OF_STOCK;
        return this.stock;
    }

    public int addToStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (this.stock == 0) this.status = ProductStatus.DRAFT;
        this.stock += quantity;
        return this.stock;
    }
}

