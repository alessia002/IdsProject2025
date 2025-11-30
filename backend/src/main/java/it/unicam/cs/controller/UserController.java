package it.unicam.cs.controller;

import it.unicam.cs.dto.RegistrationRequestDTO;
import it.unicam.cs.dto.UserDTO;
import it.unicam.cs.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) { this.service = service; }
    @PostMapping("/registration")
    public ResponseEntity<RegistrationRequestDTO> registration(@RequestBody RegistrationRequestDTO dto) { return ResponseEntity.ok(service.createRequest(dto));}

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {return ResponseEntity.ok(service.getAllUsers());}

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getByUsername(@PathVariable("username") String username) { return ResponseEntity.ok(service.getUserByUsername(username));}

}
