package it.unicam.cs.controller;

import it.unicam.cs.dto.CatalogDTO;
import it.unicam.cs.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")

public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) { this.service = service; }

    @PostMapping("/upload")
    public ResponseEntity<CatalogDTO> create(@RequestBody CatalogDTO catalogDTO) { return ResponseEntity.ok(service.create(catalogDTO)); }

    @PostMapping("/unpublish")
    public ResponseEntity<CatalogDTO> unpublish(@RequestParam("id") Long id) { return ResponseEntity.ok(service.unpublish(id)); }

    @PostMapping("/publish")
    public ResponseEntity<CatalogDTO> publish(@RequestParam("id") Long id) { return ResponseEntity.ok(service.publish(id)); }

    @PostMapping("/update")
    public ResponseEntity<CatalogDTO> update(@RequestParam("id") Long id, @RequestBody CatalogDTO dto) { return ResponseEntity.ok(service.update(id,dto)); }

    @DeleteMapping("/delete")
    public ResponseEntity<CatalogDTO> delete(@RequestParam("id") Long id) { return ResponseEntity.ok(service.delete(id)); }

    @GetMapping("/searchById")
    public ResponseEntity<CatalogDTO> searchById(@RequestParam("id") Long id) {return ResponseEntity.ok(service.searchById(id));}

    @GetMapping("/getAll")
    public ResponseEntity<List<CatalogDTO>> getAll() {return ResponseEntity.ok(service.getAll());}

    @PostMapping("/addProduct")
    public ResponseEntity<CatalogDTO> addProduct(@RequestParam("idProduct") Long idProduct, @RequestParam("idCatalog") Long idCatalog) { return ResponseEntity.ok(service.addProduct(idProduct, idCatalog)); }

    @PostMapping("/removeProduct")
    public ResponseEntity<CatalogDTO> removeProduct(@RequestParam("idProduct") Long idProduct, @RequestParam("idCatalog") Long idCatalog) { return ResponseEntity.ok(service.removeProduct(idProduct, idCatalog)); }
}
