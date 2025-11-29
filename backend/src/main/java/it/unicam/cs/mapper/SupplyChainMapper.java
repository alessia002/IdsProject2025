package it.unicam.cs.mapper;

import it.unicam.cs.dto.SupplyChainDTO;
import it.unicam.cs.model.SupplyChain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class})
public interface SupplyChainMapper {
    SupplyChainDTO  toDTO(SupplyChain entity);
    SupplyChain toEntity(SupplyChainDTO dto);
}
