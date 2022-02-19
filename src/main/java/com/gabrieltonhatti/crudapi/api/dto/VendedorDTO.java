package com.gabrieltonhatti.crudapi.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VendedorDTO implements Serializable {

    private Long id;
    private String nome;
    private BigDecimal totalVendas;
    private BigDecimal mediaVendas;

}
