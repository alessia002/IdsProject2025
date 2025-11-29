package it.unicam.cs.controller;

import it.unicam.cs.dto.MapPointDTO;
import it.unicam.cs.service.MapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapController {
    private final MapService service;

    public MapController(MapService service) {
        this.service = service;
    }

    @GetMapping("/points")
    public ResponseEntity<List<MapPointDTO>> getAllPoints() {return ResponseEntity.ok(service.getAllPoints());
    }

    @PostMapping("/createPoint")
    public ResponseEntity<MapPointDTO> createPoint(@RequestBody MapPointDTO point) {return ResponseEntity.ok(service.createPoint(point));
    }

}
