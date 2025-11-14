package it.unicam.cs.repository;

import it.unicam.cs.model.Transformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerRepository  extends JpaRepository<Transformer,String> { }
