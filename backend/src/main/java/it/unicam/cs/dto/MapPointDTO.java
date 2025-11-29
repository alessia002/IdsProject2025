package it.unicam.cs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapPointDTO {
    private Long id;
    private double lat;
    private double lon;
}
