package it.unicam.cs.service;

import it.unicam.cs.dto.UserDTO;
import it.unicam.cs.mapper.UserMapper;
import it.unicam.cs.model.*;
import it.unicam.cs.platform.DistributorFactory;
import it.unicam.cs.platform.ProducerFactory;
import it.unicam.cs.platform.TransformerFactory;
import it.unicam.cs.repository.DistributorRepository;
import it.unicam.cs.repository.ProducerRepository;
import it.unicam.cs.repository.TransformerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final ProducerRepository producerRepo;
    private final DistributorRepository distributorRepo;
    private final TransformerRepository transformerRepo;
    private final UserMapper mapper;
    private final ProducerFactory producerFactory = new ProducerFactory();
    private final TransformerFactory transformerFactory = new TransformerFactory();
    private final DistributorFactory distributorFactory = new DistributorFactory();

    public UserDTO createProducer(String name) {
        User user = producerFactory.createUser(name);
        User saved = producerRepo.save((Producer)user);
        return mapper.toDTO(saved);
    }

    public UserDTO createTransformer(UserDTO dto) {
        User user = transformerFactory.createUser(dto.getUsername());
        User saved = transformerRepo.save((Transformer)user);
        return mapper.toDTO(saved);
    }

    public UserDTO createDistributor(UserDTO dto) {
        User user = distributorFactory.createUser(dto.getUsername());
        User saved = distributorRepo.save((Distributor) user);
        return mapper.toDTO(saved);
    }

    public List<UserDTO> getAll() {
        return producerRepo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
