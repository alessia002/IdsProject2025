package it.unicam.cs.service;

import it.unicam.cs.dto.PackageDTO;
import it.unicam.cs.dto.ProductDTO;
import it.unicam.cs.mapper.PackageMapper;
import it.unicam.cs.mapper.ProductMapper;
import it.unicam.cs.model.Package;
import it.unicam.cs.model.Product;
import it.unicam.cs.repository.PackageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageService {
    private PackageRepository repo;
    private PackageMapper mapper;
    private final ProductMapper mapperProduct;
    private final ProductService productService;

    public PackageDTO create(PackageDTO dto) {
        Package Package = mapper.toEntity(dto);
        Package saved = repo.save(Package);
        return mapper.toDTO(saved);
    }

    public PackageDTO update(Long id, PackageDTO dto) {
        Package existingPackage = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));

        mapper.updateEntityFromDTO(dto, existingPackage);

        Package updated = repo.save(existingPackage);
        return mapper.toDTO(updated);
    }

    public PackageDTO delete(Long id) {
        Package delPackage = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
        repo.deleteById(id);
        return mapper.toDTO(delPackage);
    }

    public PackageDTO searchById(Long id) { return repo.findById(id).map(mapper::toDTO).orElseThrow(); }

    public List<PackageDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public PackageDTO addProduct(Long idProduct, Long idPackage) {
        ProductDTO product= productService.searchById(idProduct);
        Package productPackage = repo.findById(idPackage)
                .orElseThrow(() -> new EntityNotFoundException("Package not found with id " + idPackage));

        Product entityProduct = mapperProduct.toEntity(product);
        productPackage.addProduct(entityProduct);

        repo.save(productPackage);
        return mapper.toDTO(productPackage);
    }

    public PackageDTO removeProduct(Long idProduct, Long idPackage) {
        ProductDTO product= productService.searchById(idProduct);
        Package productPackage = repo.findById(idPackage)
                .orElseThrow(() -> new EntityNotFoundException("Package not found with id " + idPackage));

        Product entityProduct = mapperProduct.toEntity(product);
        productPackage.removeProduct(entityProduct);

        repo.save(productPackage);
        return mapper.toDTO(productPackage);
    }
}
