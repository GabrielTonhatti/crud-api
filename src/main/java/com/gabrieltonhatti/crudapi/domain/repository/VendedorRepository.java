package com.gabrieltonhatti.crudapi.domain.repository;

import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Override
    @Query("SELECT v FROM Vendedor AS v ORDER BY v.id ASC ")
    Page<Vendedor> findAll(Pageable pageable);

    @Query("SELECT AVG(v.valor) FROM Venda AS v WHERE v.vendedor.id = ?")
    BigDecimal findAVG();
}
