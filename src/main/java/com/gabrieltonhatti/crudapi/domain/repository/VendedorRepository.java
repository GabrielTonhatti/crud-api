package com.gabrieltonhatti.crudapi.domain.repository;

import com.gabrieltonhatti.crudapi.api.dto.VendedorDTO;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.infrastructure.repository.VendedorRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>, VendedorRepositoryCustom {

    @Override
    @Query("SELECT v FROM Vendedor AS v ORDER BY v.id ASC ")
    Page<Vendedor> findAll(Pageable pageable);

//    @Query("SELECT new com.gabrieltonhatti.crudapi.api.dto.VendedorDTO(v.vendedor.id, v.vendedor.nome ,SUM(v.valor)," +
//            " AVG(v.valor)) FROM Venda AS v WHERE v.vendedor.id = :id GROUP BY v.vendedor.id, v.vendedor.nome")
//    VendedorDTO calculateAVG(Long id);

}
