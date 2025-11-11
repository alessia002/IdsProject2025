package it.unicam.cs.dto;

import it.unicam.cs.enums.OrderStatus;
import it.unicam.cs.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Double total;
    private List<Product> products;
    private OrderStatus status;
}
