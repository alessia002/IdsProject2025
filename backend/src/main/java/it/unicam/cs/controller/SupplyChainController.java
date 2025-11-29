package it.unicam.cs.controller;

import it.unicam.cs.dto.SupplyChainDTO;
import it.unicam.cs.model.MapPoint;
import it.unicam.cs.service.SupplyChainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/supplyChain")
public class SupplyChainController {
    private final SupplyChainService service;

    public SupplyChainController(SupplyChainService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<SupplyChainDTO> create(@RequestBody SupplyChainDTO dto) { return ResponseEntity.ok(service.create(dto));}

    @GetMapping("/mapPoints")
    public ResponseEntity<Map<String, MapPoint>> mapPoints(@RequestParam("id") Long id) { return ResponseEntity.ok(service.mapPoints(id));}

    @GetMapping("/{id}")
    public ResponseEntity<SupplyChainDTO> getById(@PathVariable("id") Long id) { return ResponseEntity.ok(service.getById(id));}

}
