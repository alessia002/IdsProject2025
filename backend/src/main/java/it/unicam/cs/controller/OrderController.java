package it.unicam.cs.controller;

import it.unicam.cs.dto.OrderDTO;
import it.unicam.cs.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) { this.service = service; }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO OrderDTO) { return ResponseEntity.ok(service.create(OrderDTO)); }

    @PostMapping("/update")
    public ResponseEntity<OrderDTO> update(@RequestParam("id") Long id, @RequestBody OrderDTO dto) { return ResponseEntity.ok(service.update(id,dto)); }

    @GetMapping("/delete")
    public ResponseEntity<OrderDTO> delete(@RequestParam("id") Long id) {service.delete(id);return null;}

    @GetMapping("/searchById")
    public ResponseEntity<OrderDTO> searchById(@RequestParam("id") Long id) {return ResponseEntity.ok(service.searchById(id));}

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDTO>> getAll() {return ResponseEntity.ok(service.getAll());}
}
