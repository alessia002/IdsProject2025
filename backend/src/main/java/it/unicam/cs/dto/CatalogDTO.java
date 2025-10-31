package it.unicam.cs.dto;

import it.unicam.cs.enums.Status;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CatalogDTO {
    private Long id;
    private String name;
    private String description;
    private List<ProductDTO> productList;
    private int numProduct;
    private Status status;

}
