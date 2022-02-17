package com.gabrieltonhatti.crudapi.domain.service;

import com.gabrieltonhatti.crudapi.domain.exception.VendedorException;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VendedorService {

    private VendedorRepository vendedorRepository;

    @Transactional(readOnly = true)
    public Page<Vendedor> findAll(Pageable page) {
        return vendedorRepository.findAll(page);
    }

    @Transactional
    public Vendedor save(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Transactional
    public void delete(Long id) {
        vendedorRepository.deleteById(id);
    }

    public Vendedor findOrThrowException(Long id) {
        return vendedorRepository
                .findById(id)
                .orElseThrow(() -> new VendedorException(id));
    }

}
