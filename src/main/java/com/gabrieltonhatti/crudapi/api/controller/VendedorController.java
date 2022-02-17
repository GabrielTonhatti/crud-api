package com.gabrieltonhatti.crudapi.api.controller;

import com.gabrieltonhatti.crudapi.api.handleException.Message;
import com.gabrieltonhatti.crudapi.domain.exception.VendedorException;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.service.VendedorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/vendedores")
public class VendedorController {

    private VendedorService vendedorService;

    @GetMapping
    public Page<Vendedor> fildAll(Pageable page) {
        return vendedorService.findAll(page);
    }

    @PostMapping
    public ResponseEntity<Vendedor> save(@RequestBody Vendedor vendedor) {

        return ResponseEntity.status(201).body(vendedorService.save(vendedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> update(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        Vendedor vendedorAtual = vendedorService.findOrThrowException(id);

        BeanUtils.copyProperties(vendedor, vendedorAtual, "id");

        try {
            return ResponseEntity.ok(vendedorService.save(vendedorAtual));
        } catch (VendedorException e) {
            throw new VendedorException(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vendedorService.delete(id);
        Message message = createMessage("Vendedor excluído com sucesso", 200).build();
        return ResponseEntity.ok(message);
    }

    private Message.MessageBuilder createMessage(String message, Integer status) {
        return Message
                .builder()
                .message(message)
                .status(status)
                .date(LocalDateTime.now());
    }
}
