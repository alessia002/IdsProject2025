package it.unicam.cs.controller;

import it.unicam.cs.dto.ProductDTO;
import it.unicam.cs.dto.ReviewDTO;
import it.unicam.cs.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @PostMapping("/upload")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) { return ResponseEntity.ok(service.create(productDTO)); }

    @PostMapping("/unpublish")
    public ResponseEntity<ProductDTO> unpublish(@RequestParam("id") Long id) { return ResponseEntity.ok(service.unpublish(id)); }

    @PostMapping("/publish")
    public ResponseEntity<ProductDTO> publish(@RequestParam("id") Long id) { return ResponseEntity.ok(service.publish(id)); }

    @PostMapping("/update")
    public ResponseEntity<ProductDTO> update(@RequestParam("id") Long id, @RequestBody ProductDTO dto) { return ResponseEntity.ok(service.update(id,dto)); }

    @DeleteMapping("/delete")
    public ResponseEntity<ProductDTO> delete(@RequestParam("id") Long id) { return ResponseEntity.ok(service.delete(id));}

    @GetMapping("/searchById")
    public ResponseEntity<ProductDTO> searchById(@RequestParam("id") Long id) {return ResponseEntity.ok(service.searchById(id));}

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> getAll() {return ResponseEntity.ok(service.getAll());}

    @PostMapping("/addReview")
    public ResponseEntity<ProductDTO> addReview(@RequestParam("id") Long id, @RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(service.addReview(id, reviewDTO));
    }
}
