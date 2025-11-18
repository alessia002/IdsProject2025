package it.unicam.cs.dto;

import it.unicam.cs.enums.ProductStatus;
import it.unicam.cs.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private List<Product> productList;
    private int numProducts;
    private ProductStatus status;
    private String creationUserUsername;
}
