package it.unicam.cs.service;

import it.unicam.cs.dto.SupplyChainDTO;
import it.unicam.cs.mapper.SupplyChainMapper;
import it.unicam.cs.model.MapPoint;
import it.unicam.cs.model.SupplyChain;
import it.unicam.cs.model.User;
import it.unicam.cs.repository.SupplyChainRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SupplyChainService {
    private final SupplyChainRepository repo;
    private final SupplyChainMapper mapper;

    public SupplyChainDTO create(SupplyChainDTO dto) {
        SupplyChain supplyChain = mapper.toEntity(dto);
        return  mapper.toDTO(repo.save(supplyChain));
    }

    public Map<String, MapPoint> mapPoints(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supply chain does not exist"))
                .getCompanies()
                .stream()
                .collect(Collectors.toMap(
                        User::getUsername,
                        User::getLocation
                ));
    }

    public SupplyChainDTO getById(Long id) {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supply chain does not exist")));
    }
}
