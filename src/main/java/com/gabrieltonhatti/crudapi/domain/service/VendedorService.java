package com.gabrieltonhatti.crudapi.domain.service;

import com.gabrieltonhatti.crudapi.api.dto.VendedorDTO;
import com.gabrieltonhatti.crudapi.domain.exception.VendedorException;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.repository.VendaRepository;
import com.gabrieltonhatti.crudapi.domain.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class VendedorService {

    private VendedorRepository vendedorRepository;
    private VendaRepository vendaRepository;

    @Transactional(readOnly = true)
    public Page<VendedorDTO> findAllPageable(Pageable page) {
        return vendedorRepository.findAllPageable(page);
    }

    @Transactional(readOnly = true)
    public VendedorDTO findById(Long id) {
        return vendedorRepository.findVendedorById(id);
    }

    @Transactional
    public VendedorDTO save(Vendedor vendedor) {
        return new VendedorDTO(vendedorRepository.save(vendedor));
    }

    @Transactional
    public void delete(Long id) {
        try {
            vendedorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new VendedorException(id);
        }
    }

    public Vendedor findOrThrowException(Long id) {
        return vendedorRepository
                .findById(id)
                .orElseThrow(() -> new VendedorException(id));
    }

}
