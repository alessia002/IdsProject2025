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

    @PostMapping("/createCurator")
    public ResponseEntity<UserDTO> createCurator(@RequestBody UserDTO dto) { return ResponseEntity.ok(service.createCurator(dto));}

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {return ResponseEntity.ok(service.getAll());}

    @GetMapping("")
    public ResponseEntity<UserDTO> getByUsername(@RequestParam("username") String username) { return ResponseEntity.ok(service.getByUsername(username));}

}
