package it.unicam.cs.controller;

import it.unicam.cs.dto.ReviewDTO;
import it.unicam.cs.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewDTO> create(@RequestBody ReviewDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PostMapping("/update")
    public ResponseEntity<ReviewDTO> update(@RequestParam("id") Long id, @RequestBody ReviewDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ReviewDTO> delete(@RequestParam("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/searchById")
    public ResponseEntity<ReviewDTO> searchById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(service.searchById(id));
    }

    @GetMapping("/searchByProduct")
    public ResponseEntity<List<ReviewDTO>> searchByProduct(@RequestParam("productId") Long productId) {
        return ResponseEntity.ok(service.searchByProduct(productId));
    }

    @GetMapping("/searchByUser")
    public ResponseEntity<List<ReviewDTO>> searchByUser(@RequestParam("username") String username) {
        return ResponseEntity.ok(service.searchByUser(username));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ReviewDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}