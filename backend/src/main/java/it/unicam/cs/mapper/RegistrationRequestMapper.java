package it.unicam.cs.mapper;

import it.unicam.cs.dto.RegistrationRequestDTO;
import it.unicam.cs.model.RegistrationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationRequestMapper {
    RegistrationRequestDTO toDTO(RegistrationRequest entity);
    RegistrationRequest toEntity(RegistrationRequestDTO dto);
}