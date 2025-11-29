package it.unicam.cs.repository;

import it.unicam.cs.model.SupplyChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyChainRepository extends JpaRepository<SupplyChain, Long> { }
