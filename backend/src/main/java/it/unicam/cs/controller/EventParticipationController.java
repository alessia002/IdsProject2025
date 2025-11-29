package it.unicam.cs.controller;

import it.unicam.cs.dto.EventParticipationDTO;
import it.unicam.cs.service.EventParticipationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invite")
public class EventParticipationController {
    private final EventParticipationService service;

    public EventParticipationController(EventParticipationService service) {
        this.service = service;
    }

    @PostMapping("/accept")
    public ResponseEntity<EventParticipationDTO> accept(@RequestParam("id") Long id) { return ResponseEntity.ok(service.accept(id)); }

    @PostMapping("/reject")
    public ResponseEntity<EventParticipationDTO> reject(@RequestParam("id") Long id) { return ResponseEntity.ok(service.reject(id)); }

}
