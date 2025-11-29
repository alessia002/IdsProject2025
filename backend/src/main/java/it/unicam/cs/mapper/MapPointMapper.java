package it.unicam.cs.mapper;

import it.unicam.cs.dto.MapPointDTO;
import it.unicam.cs.model.MapPoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapPointMapper {
    MapPointDTO toDTO(MapPoint point);
    MapPoint toEntity(MapPointDTO dto);
}
