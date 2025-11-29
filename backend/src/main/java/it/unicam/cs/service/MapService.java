package it.unicam.cs.service;

import it.unicam.cs.dto.MapPointDTO;
import it.unicam.cs.mapper.MapPointMapper;
import it.unicam.cs.model.MapPoint;
import it.unicam.cs.repository.MapPointRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService {
    private final MapPointRepository repo;
    private final MapPointMapper mapper;

    public MapService(MapPointRepository repo, MapPointMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<MapPointDTO> getAllPoints() {
        List<MapPoint> points = repo.findAll();
        return points.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public MapPointDTO createPoint(MapPointDTO dto) {
        MapPoint point = mapper.toEntity(dto);
        MapPoint saved = repo.save(point);
        return mapper.toDTO(saved);
    }
}
