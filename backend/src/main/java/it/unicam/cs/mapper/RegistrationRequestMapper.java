package it.unicam.cs.mapper;

import it.unicam.cs.dto.RegistrationRequestDTO;
import it.unicam.cs.model.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistrationRequestMapper {

    @Mapping(target = "locationId", source = "location.id")
    @Mapping(target = "supplyChainId", source = "supplyChain.id")
    RegistrationRequestDTO toDTO(RegistrationRequest entity);

    @Mapping(target = "location", ignore = true)
    @Mapping(target = "supplyChain", ignore = true)
    RegistrationRequest toEntity(RegistrationRequestDTO dto);
}