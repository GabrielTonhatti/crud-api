package com.gabrieltonhatti.crudapi.domain.service;

import com.gabrieltonhatti.crudapi.api.dto.VendedorDTO;
import com.gabrieltonhatti.crudapi.domain.exception.EntidadeEmUsoExpcetion;
import com.gabrieltonhatti.crudapi.domain.exception.VendedorException;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.repository.VendaRepository;
import com.gabrieltonhatti.crudapi.domain.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class VendedorService {

    public static final String MSG_VENDEDOR_EM_USO = "O vendedor de código %d não pode ser removida, pois tem " +
            "vendas registradas no sistema!";
    private VendedorRepository vendedorRepository;

    public Page<VendedorDTO> findAllPageable(Pageable page) {
        return vendedorRepository.findAllPageable(page);
    }

    public VendedorDTO findById(Long id) {
        return vendedorRepository.findVendedorById(id);
    }

    public VendedorDTO save(Vendedor vendedor) {
        VendedorDTO vendedorDTO = new VendedorDTO(vendedorRepository.save(vendedor));
        if (vendedor.getId() != null) {
            VendedorDTO vendedorDTOAtual = vendedorRepository.findVendedorById(vendedor.getId());
            vendedorDTOAtual.setNome(vendedorDTO.getNome());

            return vendedorDTOAtual;
        }
        return vendedorRepository.findVendedorById(vendedor.getId());
    }

    public void delete(Long id) {
        try {
            vendedorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new VendedorException(id);
        } catch (DataIntegrityViolationException e) {
            System.out.println("TESTE");
            throw new EntidadeEmUsoExpcetion(
                    String.format(MSG_VENDEDOR_EM_USO, id)
            );
        }
    }

    public Vendedor findOrThrowException(Long id) {
        return vendedorRepository
                .findById(id)
                .orElseThrow(() -> new VendedorException(id));
    }

}
