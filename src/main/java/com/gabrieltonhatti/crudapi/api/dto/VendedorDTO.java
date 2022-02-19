package com.gabrieltonhatti.crudapi.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VendedorDTO implements Serializable {

    private Long id;
    private String nome;
    private BigDecimal totalVendas;
    private Double mediaVendas;

    public VendedorDTO() {
    }

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
    }

    public VendedorDTO(Long id, String nome, BigDecimal totalVendas, Double mediaVendas) {
        this.id = id;
        this.nome = nome;
        this.totalVendas = totalVendas;
        this.mediaVendas = mediaVendas;
    }

}
