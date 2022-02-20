package com.gabrieltonhatti.crudapi.api.controller;

import com.gabrieltonhatti.crudapi.api.dto.VendaDTO;
import com.gabrieltonhatti.crudapi.domain.exception.NegocioException;
import com.gabrieltonhatti.crudapi.domain.exception.VendaException;
import com.gabrieltonhatti.crudapi.domain.model.Venda;
import com.gabrieltonhatti.crudapi.domain.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/vendas")
public class VendaController {

    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<Page<VendaDTO>> findAll(Pageable page) {
        return ResponseEntity.ok(vendaService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VendaDTO> save(@RequestBody Venda venda) {
        try {
            return ResponseEntity.status(201).body(vendaService.save(venda));
        } catch (VendaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaDTO> update(@PathVariable Long id, @RequestBody Venda venda) {
        Venda vendaAtual = vendaService.findOrThrowException(id);

        BeanUtils.copyProperties(venda, vendaAtual, "id");

        try {
            return ResponseEntity.ok(vendaService.save(vendaAtual));
        } catch (VendaException e) {
            throw new NegocioException(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        vendaService.delete(id);
    }
}
