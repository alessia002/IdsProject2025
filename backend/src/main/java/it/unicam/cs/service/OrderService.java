package it.unicam.cs.service;

import it.unicam.cs.dto.OrderDTO;
import it.unicam.cs.mapper.OrderMapper;
import it.unicam.cs.model.Order;
import it.unicam.cs.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository repo;
    private OrderMapper mapper;

    public OrderDTO create(OrderDTO dto) {
        Order order = mapper.toEntity(dto);
        Order saved = repo.save(order);
        return mapper.toDTO(saved);
    }

    public OrderDTO update(Long id, OrderDTO dto) {
        Order existingOrder = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));

        mapper.updateEntityFromDTO(dto, existingOrder);

        Order updated = repo.save(existingOrder);
        return mapper.toDTO(updated);
    }

    public OrderDTO delete(Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
        repo.deleteById(id);
        return mapper.toDTO(order);
    }

    public OrderDTO searchById(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElseThrow();
    }

    public List<OrderDTO> getAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
