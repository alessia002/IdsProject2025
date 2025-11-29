package it.unicam.cs.model;

import it.unicam.cs.enums.RequestStatus;
import it.unicam.cs.enums.Role;
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
    @Enumerated(EnumType.STRING)
    private Role requestedRole;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private MapPoint location;
    @ManyToOne
    @JoinColumn(name = "supply_chain_id")
    private SupplyChain supplyChain;

    public void approve() {
        setStatus(RequestStatus.APPROVED);
    }
    public void reject() {
        setStatus(RequestStatus.REJECTED);
    }
}
