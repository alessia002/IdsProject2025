package it.unicam.cs.model;

import it.unicam.cs.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
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
    private LocalDateTime date;
    private Double price;
    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @ManyToMany
    @JoinTable(
            name = "order_packages",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id")
    )
    private List<Package> packages;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "creation_user_username")
    private User creationUser;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }

    public void addProduct(Product product) {
        if (product == null) return;
        products.add(product);
        price += product.getPrice();
    }

    public void removeProduct(Product product) {
        if (product == null || !products.contains(product)) return;
        products.remove(product);
        price -= product.getPrice();
    }

    public void addPackage(Package pack) {
        if (pack == null) return;
        packages.add(pack);
        price += pack.getPrice();
    }

    public void removePackage(Package pack) {
        if (pack == null || !packages.contains(pack)) return;
        packages.remove(pack);
        price -= pack.getPrice();
    }

    public void confirm(){
        this.status = OrderStatus.CONFIRMED;
    }

    public void cancel(){
        this.status = OrderStatus.CANCELED;
    }

    public void complete(){
        this.status = OrderStatus.COMPLETED;
    }
}
