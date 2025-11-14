package it.unicam.cs.dto;

import it.unicam.cs.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private String description;
    private double rating;
    private Long productId;
    private String creationUserUsername;
    private Long productId ;
}
