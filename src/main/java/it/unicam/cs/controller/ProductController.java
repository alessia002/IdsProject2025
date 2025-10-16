package it.unicam.cs.controller;

import it.unicam.cs.model.Product;
import it.unicam.cs.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product) { return ResponseEntity.ok(service.create(product)); }

    @PostMapping("/update")
    public ResponseEntity<Product> update(@RequestParam("id") Long id, @RequestBody Product product) { return ResponseEntity.ok(service.update(id,product)); }

    @GetMapping("/delete")
    public ResponseEntity<Product> delete(@RequestParam("id") Long id) {
        service.delete(id);
        return null;
    }

    @GetMapping("/searchById")
    public ResponseEntity<Product> searchById(@RequestParam("id") Long id) {return ResponseEntity.ok(service.searchById(id));}
}
