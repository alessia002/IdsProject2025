package it.unicam.cs.service;

import it.unicam.cs.enums.Role;
import it.unicam.cs.model.User;
import it.unicam.cs.dto.RegistrationRequestDTO;
import it.unicam.cs.dto.UserDTO;
import it.unicam.cs.enums.RequestStatus;
import it.unicam.cs.mapper.RegistrationRequestMapper;
import it.unicam.cs.mapper.UserMapper;
import it.unicam.cs.model.*;
import it.unicam.cs.platform.*;
import it.unicam.cs.repository.MapPointRepository;
import it.unicam.cs.repository.RegistrationRequestRepository;
import it.unicam.cs.repository.SupplyChainRepository;
import it.unicam.cs.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepo;
    private final UserMapper mapper;
    private final RegistrationRequestRepository registrationRepo;
    private final RegistrationRequestMapper registrationMapper;
    private final SupplyChainRepository supplyChainRepo;
    private final MapPointRepository mapPointRepo;

    public RegistrationRequestDTO createRequest(RegistrationRequestDTO dto) {
        if (userRepo.findById(dto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        //controllare per username e role
        if (registrationRepo.findById(dto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username registration request already exists");
        }
        SupplyChain supplyChain = supplyChainRepo.findById(dto.getSupplyChainId()).orElseThrow(() -> new EntityNotFoundException("Supply chain does not exists"));
        MapPoint mapPoint = mapPointRepo.findById(dto.getLocationId()).orElseThrow(() -> new EntityNotFoundException("MapPoint does not exists"));

        RegistrationRequest request = registrationMapper.toEntity(dto);
        request.setSupplyChain(supplyChain);
        request.setLocation(mapPoint);
        request.setStatus(RequestStatus.PENDING);
        request.setPassword(encoder.encode(dto.getPassword()));
        RegistrationRequest saved = registrationRepo.save(request);
        return registrationMapper.toDTO(saved);
    }

    public RegistrationRequestDTO approveRequest(String username){
        RegistrationRequest request = registrationRepo.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("Request does not exist"));

        User user = userRepo.findById(username).orElse(null);
        UserFactory userFactory = UserFactorySelector.getFactory(request.getRequestedRole());
        if (user == null) {
            user = userFactory.createUser(request);
        } else {
            user = userFactory.authorizeUser(user);
        }
        request.getSupplyChain().addCompany(user);
        request.approve();
        registrationRepo.save(request);
        return registrationMapper.toDTO(request);
    }

    public RegistrationRequestDTO rejectRequest(String username){
        RegistrationRequest request = registrationRepo.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("Request does not exist"));
        request.reject();
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

    public UserDTO removeRole(String username, String role) {
        User user = userRepo.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("User " + username + " not found"));
        if (Arrays.stream(Role.values()).noneMatch(r -> r.name().equalsIgnoreCase(role))) {
            throw new IllegalArgumentException("Role " + role + " not found");
        }

        UserFactory userFactory = UserFactorySelector.getFactory(Role.valueOf(role.toUpperCase()));
        userFactory.unauthorizeUser(user);

        userRepo.save(user);
        return mapper.toDTO(user);
    }

    public UserDTO addRole(String username, String role) {
        User user = userRepo.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("User " + username + " not found"));

        UserFactory userFactory = UserFactorySelector.getFactory(Role.valueOf(role));
        userFactory.authorizeUser(user);

        userRepo.save(user);
        return mapper.toDTO(user);
    }
}