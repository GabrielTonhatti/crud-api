package com.gabrieltonhatti.crudapi.api.dto;

import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import lombok.*;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VendedorDTO implements Serializable {

    private Long id;
    private String nome;
    private BigDecimal totalVendas;
    private BigDecimal mediaVendas;

//    public VendedorDTO(Page<Vendedor> vendedores) {
//
//    }
}
