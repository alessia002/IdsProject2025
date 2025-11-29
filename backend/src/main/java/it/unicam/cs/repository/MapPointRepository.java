package it.unicam.cs.repository;

import it.unicam.cs.model.MapPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapPointRepository extends JpaRepository<MapPoint, Long> {
}
