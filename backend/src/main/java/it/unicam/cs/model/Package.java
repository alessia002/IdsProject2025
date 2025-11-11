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
    private Double total = 0.0;
    @ManyToMany
    @JoinTable(
            name = "package_products",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public void addProduct(Product product) {
        if (product == null) return;
        productList.add(product);
        total += product.getPrice();
    }

    public void removeProduct(Product product) {
        if (product == null || !productList.contains(product)) return;
        productList.remove(product);
        total -= product.getPrice();
    }

}
