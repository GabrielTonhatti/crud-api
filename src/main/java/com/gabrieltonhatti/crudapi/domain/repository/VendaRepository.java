package com.gabrieltonhatti.crudapi.domain.repository;

import com.gabrieltonhatti.crudapi.domain.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
