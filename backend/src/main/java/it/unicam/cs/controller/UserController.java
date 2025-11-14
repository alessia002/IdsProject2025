package it.unicam.cs.controller;

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

    @PostMapping("/createProducer")
    public ResponseEntity<UserDTO> createProducer(@RequestBody UserDTO dto) { return ResponseEntity.ok(service.createProducer(dto));}

    @PostMapping("/createTransformer")
    public ResponseEntity<UserDTO> createTransformer(@RequestBody UserDTO dto) { return ResponseEntity.ok(service.createTransformer(dto));}

    @PostMapping("/createDistributor")
    public ResponseEntity<UserDTO> createDistributor(@RequestBody UserDTO dto) { return ResponseEntity.ok(service.createDistributor(dto));}

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {return ResponseEntity.ok(service.getAll());}

}
