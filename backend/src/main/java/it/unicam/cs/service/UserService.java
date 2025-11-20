package it.unicam.cs.service;

import it.unicam.cs.model.User;
import it.unicam.cs.dto.RegistrationRequestDTO;
import it.unicam.cs.dto.UserDTO;
import it.unicam.cs.enums.RequestStatus;
import it.unicam.cs.mapper.RegistrationRequestMapper;
import it.unicam.cs.mapper.UserMapper;
import it.unicam.cs.model.*;
import it.unicam.cs.platform.CuratorFactory;
import it.unicam.cs.platform.DistributorFactory;
import it.unicam.cs.platform.ProducerFactory;
import it.unicam.cs.platform.TransformerFactory;
import it.unicam.cs.repository.RegistrationRequestRepository;
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
    private final UserRepository userRepo;
    private final UserMapper mapper;
    private final ProducerFactory producerFactory = new ProducerFactory();
    private final TransformerFactory transformerFactory = new TransformerFactory();
    private final DistributorFactory distributorFactory = new DistributorFactory();
    private final CuratorFactory curatorFactory;
    private final RegistrationRequestRepository registrationRepo;
    private final RegistrationRequestMapper registrationMapper;

    public RegistrationRequestDTO createRequest(RegistrationRequestDTO dto) {
        if (userRepo.findById(dto.getUsername()).isPresent()) {
            throw new EntityNotFoundException("Username already exists");
        }
        if (registrationRepo.findById(dto.getUsername()).isPresent()) {
            throw new EntityNotFoundException("Username registration request already exists");
        }
        RegistrationRequest request = registrationMapper.toEntity(dto);
        request.setStatus(RequestStatus.PENDING);
        RegistrationRequest saved = registrationRepo.save(request);
        return registrationMapper.toDTO(saved);
    }

    public RegistrationRequestDTO approveRequest(String username){
        RegistrationRequest request = registrationRepo.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("Request does not exist"));

        //User user = userRepo.findById(username)
                //.orElse(null ); da gestire nel caso utente esiste UC

        User created = new User();
        if (request.getRequestedRole().equals("PRODUCER")) {
            created = producerFactory.createUser(request);
        }
        if (request.getRequestedRole().equals("TRANSFORMER")) {
            created = transformerFactory.createUser(request);
        }
        if (request.getRequestedRole().equals("DISTRIBUTOR")) {
            created = distributorFactory.createUser(request);
        }
        if (request.getRequestedRole().equals("CURATOR")) {
            created = curatorFactory.createUser(request);
        }
        created.setPassword(encoder.encode(request.getPassword()));
        userRepo.save(created);
        request.setStatus(RequestStatus.APPROVED);
        return registrationMapper.toDTO(request);
    }

    public RegistrationRequestDTO rejectRequest(String username){
        RegistrationRequest request = registrationRepo.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("Request does not exist"));
        request.setStatus(RequestStatus.REJECTED);
        registrationRepo.save(request);
        return registrationMapper.toDTO(request);
    }

    public List<RegistrationRequestDTO> getAllRequests() {
        return registrationRepo.findAll().stream().map(registrationMapper::toDTO).collect(Collectors.toList());
    }

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public RegistrationRequestDTO getRequestByUsername(String username) {
        return registrationRepo.findById(username).map(registrationMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Request for user " + username + " not found"));
    }

    public UserDTO getUserByUsername(String username) {
        return userRepo.findById(username).map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("User " + username + " not found"));
    }
}