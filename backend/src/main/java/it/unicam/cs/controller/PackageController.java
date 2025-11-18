package it.unicam.cs.controller;

import it.unicam.cs.dto.PackageDTO;
import it.unicam.cs.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Secured("ROLE_DISTRIBUTOR")
@RequestMapping("/api/package")
public class PackageController {
    private final PackageService service;

    public PackageController(PackageService service) { this.service = service; }

    @PostMapping("/create")
    public ResponseEntity<PackageDTO> create(@RequestBody PackageDTO dto) { return ResponseEntity.ok(service.create(dto)); }

    @PostMapping("/update")
    public ResponseEntity<PackageDTO> update(@RequestParam("id") Long id, @RequestBody PackageDTO dto) { return ResponseEntity.ok(service.update(id,dto)); }

    @DeleteMapping("/delete")
    public ResponseEntity<PackageDTO> delete(@RequestParam("id") Long id) { return ResponseEntity.ok(service.delete(id)); }

    @GetMapping("/searchById")
    public ResponseEntity<PackageDTO> searchById(@RequestParam("id") Long id) {return ResponseEntity.ok(service.searchById(id));}

    @GetMapping("/getAll")
    public ResponseEntity<List<PackageDTO>> getAll() {return ResponseEntity.ok(service.getAll());}

    @PostMapping("/addProduct")
    public ResponseEntity<PackageDTO> addProduct(@RequestParam("idProduct") Long idProduct, @RequestParam("idPackage") Long idPackage) { return ResponseEntity.ok(service.addProduct(idProduct, idPackage)); }

    @PostMapping("/removeProduct")
    public ResponseEntity<PackageDTO> removeProduct(@RequestParam("idProduct") Long idProduct, @RequestParam("idPackage") Long idPackage) { return ResponseEntity.ok(service.removeProduct(idProduct, idPackage)); }
}
