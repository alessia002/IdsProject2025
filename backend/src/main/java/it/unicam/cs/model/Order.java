package it.unicam.cs.model;


import it.unicam.cs.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name= "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total = 0.0;
    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addProduct(Product product) {
        if (product == null) return;
        products.add(product);
        total += product.getPrice();
    }

    public void removeProduct(Product product) {
        if (product == null || !products.contains(product)) return;
        products.remove(product);
        total -= product.getPrice();
    }

    public void addPackage(Package pack) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
