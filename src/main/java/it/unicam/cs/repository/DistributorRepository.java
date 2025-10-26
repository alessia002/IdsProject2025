package it.unicam.cs.repository;

import it.unicam.cs.model.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository  extends JpaRepository<Distributor,Long> { }
