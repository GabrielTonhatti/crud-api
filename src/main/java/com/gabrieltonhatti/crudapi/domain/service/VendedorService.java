package com.gabrieltonhatti.crudapi.domain.service;

import com.gabrieltonhatti.crudapi.api.dto.VendedorDTO;
import com.gabrieltonhatti.crudapi.domain.exception.VendedorException;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VendedorService {

    private VendedorRepository vendedorRepository;

    @Transactional(readOnly = true)
    public Page<Vendedor> findAll(Pageable page) {
        Page<Vendedor> vendedores = vendedorRepository.findAll(page);
        vendedores.map(vendedor -> {
            System.out.println(vendedor);

            return null;
        });
        return vendedorRepository.findAll(page);
    }

    @Transactional
    public Vendedor save(Vendedor vendedor) {
        System.out.println(vendedorRepository.findAVG());
        vendedor.setMediaVendas(vendedorRepository.findAVG());

        return vendedorRepository.save(vendedor);
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
