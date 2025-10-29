package it.unicam.cs.service;

import it.unicam.cs.dto.ProductDTO;
import it.unicam.cs.mapper.ProductMapper;
import it.unicam.cs.model.Product;
import it.unicam.cs.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repo;
    private final ProductMapper mapper;

    public ProductDTO create(ProductDTO dto) {
        Product product = mapper.toEntity(dto);
        product.unpublish();
        Product saved = repo.save(product);
        return mapper.toDTO(saved);
    }

    public ProductDTO unpublish(Long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
        product.unpublish();
        repo.save(product);
        return mapper.toDTO(product);
    }

    public ProductDTO publish(Long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
        product.publish();
        repo.save(product);
        return mapper.toDTO(product);
    }

    public ProductDTO update(Long id, ProductDTO dto) {
        Product existingProduct = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));

        mapper.updateEntityFromDTO(dto, existingProduct);

        Product updated = repo.save(existingProduct);
        return mapper.toDTO(updated);
    }


    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Product not found with id " + id);
        }
        repo.deleteById(id);
    }

    public ProductDTO searchById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow();
    }

    public List<ProductDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
