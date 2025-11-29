package it.unicam.cs.dto;

import it.unicam.cs.enums.ProductStatus;
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
    private List<ProductDTO> productList;
    private int numProducts;
    private ProductStatus status;
    private String creationUserUsername;
}
