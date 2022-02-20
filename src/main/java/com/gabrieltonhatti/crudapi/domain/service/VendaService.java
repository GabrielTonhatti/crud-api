package com.gabrieltonhatti.crudapi.domain.service;

import com.gabrieltonhatti.crudapi.api.dto.VendaDTO;
import com.gabrieltonhatti.crudapi.domain.exception.VendaException;
import com.gabrieltonhatti.crudapi.domain.model.Venda;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.repository.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class VendaService {

    private VendaRepository vendaRepository;
    private VendedorService vendedorService;

    @Transactional(readOnly = true)
    public Page<VendaDTO> findAll(Pageable page) {
        Page<Venda> vendas = vendaRepository.findAll(page);
        return vendas.map(VendaDTO::new);
    }

    @Transactional
    public VendaDTO save(Venda venda) {

        try {
            Vendedor vendedor = vendedorService.findOrThrowException(venda.getVendedor().getId());
            venda.getVendedor().setNome(vendedor.getNome());
            vendaRepository.save(venda);

            System.out.println(venda);
            return new VendaDTO(venda);
        } catch (EmptyResultDataAccessException e) {
            throw new VendaException(venda.getId());
        }

    }

    @Transactional
    public void delete(Long id) {
        try {
            vendaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new VendaException(id);
        }
    }



}
