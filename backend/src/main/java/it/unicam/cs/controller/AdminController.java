package it.unicam.cs.controller;

import it.unicam.cs.dto.RegistrationRequestDTO;
import it.unicam.cs.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService service;

    public AdminController(UserService service) { this.service = service; }

    @PostMapping("/approveRequest")
    public ResponseEntity<RegistrationRequestDTO> approveRequest(@RequestParam("username") String username) { return ResponseEntity.ok(service.approveRequest(username));}

    @PostMapping("/rejectRequest")
    public ResponseEntity<RegistrationRequestDTO> rejectRequest(@RequestParam("username") String username) { return ResponseEntity.ok(service.rejectRequest(username));}

    @GetMapping("/getAllRequests")
    public ResponseEntity<List<RegistrationRequestDTO>> getAllRequests() { return ResponseEntity.ok(service.getAllRequests());}

    @GetMapping("/request")
    public ResponseEntity<RegistrationRequestDTO> getByUsername(@RequestParam("username") String username) { return ResponseEntity.ok(service.getRequestByUsername(username));}


}
