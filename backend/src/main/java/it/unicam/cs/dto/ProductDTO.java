package it.unicam.cs.dto;

import it.unicam.cs.enums.ProductStatus;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stock;
    private ProductStatus status;
    private List<ReviewDTO> reviews;
    private String creationUserUsername;
}
