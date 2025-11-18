package it.unicam.cs.model;

import it.unicam.cs.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Table(name= "packages")
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    @ManyToMany
    @JoinTable(
            name = "package_products",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;
    private int numProducts;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @ManyToOne
    @JoinColumn(name = "creation_user_username")
    private User creationUser;

    public void addProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product must not be null");
        }
        if(product.getStatus()!=ProductStatus.PUBLISHED){
            throw new IllegalArgumentException("Product is not published");
        }
        productList.add(product);
        this.price += product.getPrice();
    }

    public void removeProduct(Product product) {
        if (product == null || !productList.contains(product)) return;
        productList.remove(product);
        this.price -= product.getPrice();
    }

    public void removeFromStock(int quantity) {
        if(productList.stream().anyMatch(product -> product.getStock() < quantity)) {
            throw new IllegalArgumentException("Not enough products in stock");
        }
        productList.forEach(product -> product.removeFromStock(quantity));
    }

}
