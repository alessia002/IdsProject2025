package it.unicam.cs.model;

import it.unicam.cs.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Table(name= "catalog")
@NoArgsConstructor
@AllArgsConstructor

public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<Product> productList;
    private int numProduct;
    private Status status;

    public void unpublish() {
        this.status = Status.DRAFT;
    }

    public void publish() {
        this.status = Status.PUBLISHED;
    }

    public void addProduct(Product p) { this.productList.add(p);}

    public void removeProduct(Product p){ this.productList.remove(p);}

}
