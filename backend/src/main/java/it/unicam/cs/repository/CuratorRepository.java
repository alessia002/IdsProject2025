package it.unicam.cs.repository;

import it.unicam.cs.model.Curator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratorRepository  extends JpaRepository<Curator,Long> { }
