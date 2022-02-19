package com.gabrieltonhatti.crudapi.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "vendedores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vendedor {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal totalVendas;

    @Column(name = "media_vendas_diarias")
    private BigDecimal mediaVendas;

}
