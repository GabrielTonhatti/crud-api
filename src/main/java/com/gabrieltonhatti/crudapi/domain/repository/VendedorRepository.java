package com.gabrieltonhatti.crudapi.domain.repository;

import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
