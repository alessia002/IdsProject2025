package it.unicam.cs.dto;

import it.unicam.cs.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime date;
    private double price;
    private List<ProductDTO> products;
    private List<PackageDTO> packages;
    private OrderStatus status;
    private String creationUserUsername;
}
