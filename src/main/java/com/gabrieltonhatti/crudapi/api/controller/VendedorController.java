package com.gabrieltonhatti.crudapi.api.controller;

import com.gabrieltonhatti.crudapi.api.dto.VendedorDTO;
import com.gabrieltonhatti.crudapi.domain.exception.VendedorException;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.service.VendedorService;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/vendedores")
public class VendedorController {

    private VendedorService vendedorService;

    @GetMapping
    public Page<VendedorDTO> findAllTeste(@RequestParam(required = false) String data, @ParameterObject Pageable page) {
        return vendedorService.findAllForData(data, page);
    }

    @GetMapping("/{id}")
    public VendedorDTO fildById(@PathVariable Long id) {
        return vendedorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendedorDTO save(@RequestBody @Valid Vendedor vendedor) {
        return vendedorService.save(vendedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> update(@PathVariable Long id, @RequestBody @Valid Vendedor vendedor) {
        Vendedor vendedorAtual = vendedorService.findOrThrowException(id);

        BeanUtils.copyProperties(vendedor, vendedorAtual, "id");

        try {
            return ResponseEntity.ok(vendedorService.save(vendedorAtual));
        } catch (VendedorException e) {
            throw new VendedorException(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        vendedorService.delete(id);
    }

}
