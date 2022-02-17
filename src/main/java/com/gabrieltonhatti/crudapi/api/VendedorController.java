package com.gabrieltonhatti.crudapi.api;

import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import com.gabrieltonhatti.crudapi.domain.service.VendedorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("vendedores")
public class VendedorController {

    private VendedorService vendedorService;

    @GetMapping
    public Page<Vendedor> fildAll(Pageable page) {
        return  vendedorService.findAll(page);
    }

    @PostMapping
    public Vendedor findAll(@RequestBody Vendedor vendedor) {

        return null;
    }
}
