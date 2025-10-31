package it.unicam.cs.repository;

import it.unicam.cs.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository  extends JpaRepository<Catalog,Long> { }
