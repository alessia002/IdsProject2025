package it.unicam.cs.dto;

import it.unicam.cs.enums.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDTO {
    private String username;
    private String password;
    private String requestedRole;
    private RequestStatus status;
    private Long locationId;
    private Long supplyChainId;
}