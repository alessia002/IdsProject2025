package it.unicam.cs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyChainDTO {
    private Long id;
    private String title;
    private String description;
    private List<UserDTO> companies;
}
