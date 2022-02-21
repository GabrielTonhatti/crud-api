package com.gabrieltonhatti.crudapi.infrastructure.repository;

import com.gabrieltonhatti.crudapi.api.dto.VendedorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendedorRepositoryCustom {

    Page<VendedorDTO> findAllPageable(Pageable page);
    Page<VendedorDTO> findAllForData(String data, Pageable page);
    VendedorDTO findVendedorById(Long id);
}
