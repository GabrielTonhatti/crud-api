package com.gabrieltonhatti.crudapi.domain.repository;

import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.infrastructure.repository.VendedorRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>, VendedorRepositoryCustom {

//    @Override
//    @Query("SELECT v FROM Vendedor AS v ORDER BY v.id ASC ")
//    Page<Vendedor> findAll(Pageable pageable);

}
