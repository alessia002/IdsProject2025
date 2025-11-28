package it.unicam.cs.controller;

import it.unicam.cs.dto.ShareContentDTO;
import it.unicam.cs.service.SocialShareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/share")
public class SocialShareController {
    private final SocialShareService service;

    public SocialShareController(SocialShareService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShareContentDTO> share(@RequestBody ShareContentDTO dto) {
        return ResponseEntity.ok(service.share(dto));
    }
}
