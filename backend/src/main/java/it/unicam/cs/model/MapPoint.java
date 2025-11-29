package it.unicam.cs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "map_point")
@NoArgsConstructor
@AllArgsConstructor
public class MapPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private double lat;
    @Column(nullable = false)
    private double lon;
}
