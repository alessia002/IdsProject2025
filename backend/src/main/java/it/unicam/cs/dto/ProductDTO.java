package it.unicam.cs.dto;

import it.unicam.cs.enums.ProductStatus;
import it.unicam.cs.model.Review;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private ProductStatus status;
    private List<ReviewDTO> reviews;
}
