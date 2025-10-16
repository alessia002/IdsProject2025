package it.unicam.cs.service;

import it.unicam.cs.model.Product;
import it.unicam.cs.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) { this.repo = repo; }

    public Product create(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product product) {
        Optional<Product> existingProduct = repo.findById(id);
        if (existingProduct.isEmpty()) {
            throw new EntityNotFoundException("Product not found with id " + id);
        }
        if (existingProduct.get().equals(product)) {
            return existingProduct.get();
        }
        existingProduct.get().setName(product.getName());
        existingProduct.get().setPrice(product.getPrice());
        existingProduct.get().setCategory(product.getCategory());
        Product existing = existingProduct.get();
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Product searchById(Long id) {
        return repo.findById(id).get();
    }
}
