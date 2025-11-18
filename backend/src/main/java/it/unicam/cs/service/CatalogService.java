package it.unicam.cs.service;

import it.unicam.cs.dto.CatalogDTO;
import it.unicam.cs.dto.ProductDTO;
import it.unicam.cs.mapper.CatalogMapper;
import it.unicam.cs.mapper.ProductMapper;
import it.unicam.cs.model.Catalog;
import it.unicam.cs.model.Product;
import it.unicam.cs.repository.CatalogRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogService {
    private final CatalogRepository repo;
    private final CatalogMapper mapper;
    private final ProductMapper mapperProduct;
    private final ProductService productService;

    public CatalogDTO create(CatalogDTO dto) {
        Catalog catalog = mapper.toEntity(dto);
        catalog.unpublish();
        Catalog saved = repo.save(catalog);
        return mapper.toDTO(saved);
    }

    public CatalogDTO unpublish(Long id) {
        Catalog catalog = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + id));
        catalog.unpublish();
        repo.save(catalog);
        return mapper.toDTO(catalog);
    }

    public CatalogDTO publish(Long id) {
        Catalog catalog = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + id));
        catalog.publish();
        repo.save(catalog);
        return mapper.toDTO(catalog);
    }

    public CatalogDTO update(Long id, CatalogDTO dto) {
        Catalog existingCatalog = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + id));

        mapper.updateEntityFromDTO(dto, existingCatalog);

        Catalog updated = repo.save(existingCatalog);
        return mapper.toDTO(updated);
    }


    public CatalogDTO delete(Long id) {
        Catalog catalog = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + id));
        CatalogDTO dto = mapper.toDTO(catalog);
        repo.deleteById(id);
        return dto;
    }

    public CatalogDTO searchById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow();
    }

    public List<CatalogDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public CatalogDTO addProduct(Long idProduct, Long idCatalog) {
        ProductDTO product= productService.searchById(idProduct);
        Catalog catalog = repo.findById(idCatalog)
                .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + idCatalog));

        Product entityProduct = mapperProduct.toEntity(product);
        catalog.addProduct(entityProduct);

        repo.save(catalog);
        return mapper.toDTO(catalog);
    }

    public CatalogDTO removeProduct(Long idProduct, Long idCatalog) {
        ProductDTO product= productService.searchById(idProduct);
        Catalog catalog = repo.findById(idCatalog)
                .orElseThrow(() -> new EntityNotFoundException("Catalog not found with id " + idCatalog));

        Product entityProduct = mapperProduct.toEntity(product);
        catalog.removeProduct(entityProduct);

        repo.save(catalog);
        return mapper.toDTO(catalog);
    }


}
