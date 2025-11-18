package it.unicam.cs.service;

import it.unicam.cs.dto.ProductDTO;
import it.unicam.cs.dto.ReviewDTO;
import it.unicam.cs.mapper.ProductMapper;
import it.unicam.cs.mapper.ReviewMapper;
import it.unicam.cs.model.Product;
import it.unicam.cs.model.Review;
import it.unicam.cs.platform.ProductDecorator;
import it.unicam.cs.platform.ReviewDecorator;
import it.unicam.cs.repository.ProductRepository;
import it.unicam.cs.repository.ReviewRepository;
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
    private final ReviewRepository reviewRepo;
    private final ReviewMapper reviewMapper;

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

    public ProductDTO validate(Long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
        product.validate();
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


    public ProductDTO delete(Long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
        ProductDTO dto = mapper.toDTO(product);
        repo.deleteById(id);
        return dto;
    }

    public ProductDTO searchById(Long id) {
        return repo.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    public List<ProductDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public ProductDTO addReview(Long id, ReviewDTO reviewDto) {
        Product existingProduct = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));

        Review review = reviewMapper.toEntity(reviewDto);
        review.setProduct(existingProduct);

        ProductDecorator reviewDecorator = new ReviewDecorator(existingProduct);
        reviewDecorator.addReview(review);

        Product updated = repo.save(existingProduct);
        return mapper.toDTO(updated);
    }
}
