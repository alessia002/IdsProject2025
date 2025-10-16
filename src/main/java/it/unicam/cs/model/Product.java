package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@Table(name= "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String category;

    public Product() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

