package it.unicam.cs.model;

import it.unicam.cs.enums.ProductStatus;
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
    @Enumerated(EnumType.STRING)
    @OneToMany
    private List<Package> packageList;
    private int numPackage;
    private ProductStatus status;
    @ManyToOne
    @JoinColumn(name = "creation_user_username")
    private User creationUser;

    public void unpublish() {
        this.status = ProductStatus.DRAFT;
    }

    public void publish() {
        this.status = ProductStatus.PUBLISHED;
    }

    public void addProduct(Product p) {
        this.productList.add(p);
        this.numProduct += 1;
    }

    public void removeProduct(Product p){
        this.productList.remove(p);
        this.numProduct -= 1; }

    public void addPackage(Package p) {
        this.packageList.add(p);
        this.numPackage += 1;
    }

    public void removePackage(Package p){
        this.packageList.remove(p);
        this.numPackage -= 1;
    }
}
