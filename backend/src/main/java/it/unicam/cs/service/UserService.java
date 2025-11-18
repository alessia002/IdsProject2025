package it.unicam.cs.service;

import it.unicam.cs.dto.UserDTO;
import it.unicam.cs.mapper.UserMapper;
import it.unicam.cs.model.*;
import it.unicam.cs.platform.CuratorFactory;
import it.unicam.cs.platform.DistributorFactory;
import it.unicam.cs.platform.ProducerFactory;
import it.unicam.cs.platform.TransformerFactory;
import it.unicam.cs.repository.CuratorRepository;
import it.unicam.cs.repository.DistributorRepository;
import it.unicam.cs.repository.ProducerRepository;
import it.unicam.cs.repository.TransformerRepository;
import it.unicam.cs.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder encoder;
    private final ProducerRepository producerRepo;
    private final DistributorRepository distributorRepo;
    private final TransformerRepository transformerRepo;
    private final UserRepository userRepo;
    private final UserMapper mapper;
    private final ProducerFactory producerFactory = new ProducerFactory();
    private final TransformerFactory transformerFactory = new TransformerFactory();
    private final DistributorFactory distributorFactory = new DistributorFactory();
    private final CuratorFactory curatorFactory;
    private final CuratorRepository curatorRepository;

    public UserDTO createProducer(UserDTO dto) {
        if (producerRepo.findById(dto.getUsername()).isPresent()) {
            throw new EntityNotFoundException("Username already exists");
        }
        User user = producerFactory.createUser(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        User saved = producerRepo.save((Producer)user);
        return mapper.toDTO(saved);
    }

    public UserDTO createTransformer(UserDTO dto) {
        if (producerRepo.findById(dto.getUsername()).isPresent()) {
            throw new EntityNotFoundException("Username already exists");
        }
        User user = transformerFactory.createUser(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        User saved = transformerRepo.save((Transformer)user);
        return mapper.toDTO(saved);
    }

    public UserDTO createDistributor(UserDTO dto) {
        if (producerRepo.findById(dto.getUsername()).isPresent()) {
            throw new EntityNotFoundException("Username already exists");
        }
        User user = distributorFactory.createUser(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        User saved = distributorRepo.save((Distributor) user);
        return mapper.toDTO(saved);
    }

    public UserDTO createCurator(UserDTO dto) {
        if (producerRepo.findById(dto.getUsername()).isPresent()) {
            throw new EntityNotFoundException("Username already exists");
        }
        User user = curatorFactory.createUser(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        User saved = curatorRepository.save((Curator) user);
        return mapper.toDTO(saved);
    }


    public List<UserDTO> getAll() {
        return userRepo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public UserDTO getByUsername(String username) {
        return userRepo.findById(username).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("User " + username + " not found"));
    }
}
