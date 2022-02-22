package com.gabrieltonhatti.crudapi.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "vendedores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vendedor {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nome do vendedor")
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

}
