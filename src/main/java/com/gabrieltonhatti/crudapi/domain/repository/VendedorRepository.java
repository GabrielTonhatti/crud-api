package com.gabrieltonhatti.crudapi.domain.repository;

import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Override
    @Query("SELECT v FROM Vendedor AS v ORDER BY v.id ASC ")
    Page<Vendedor> findAll(Pageable pageable);
}
