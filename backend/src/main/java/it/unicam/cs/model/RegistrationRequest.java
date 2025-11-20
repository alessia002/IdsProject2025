package it.unicam.cs.model;

import it.unicam.cs.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "registration_request")
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    @Id
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String requestedRole;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}
