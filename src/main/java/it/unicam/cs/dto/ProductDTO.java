package it.unicam.cs.dto;

import it.unicam.cs.enums.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private Status status;
}
