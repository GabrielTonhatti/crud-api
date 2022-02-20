package com.gabrieltonhatti.crudapi.domain.repository;

import com.gabrieltonhatti.crudapi.domain.model.Venda;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Override
    @Query("SELECT v FROM Venda AS v ORDER BY v.id ASC ")
    Page<Venda> findAll(Pageable pageable);

}
