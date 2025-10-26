package it.unicam.cs.model;

import it.unicam.cs.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String category;
    @Enumerated(EnumType.STRING)
    private Status status;

    public void unpublish() {
        this.status = Status.DRAFT;
    }

    public void publish() {
        this.status = Status.PUBLISHED;
    }
}

