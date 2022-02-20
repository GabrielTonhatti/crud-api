package com.gabrieltonhatti.crudapi.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrieltonhatti.crudapi.domain.model.Venda;
import com.gabrieltonhatti.crudapi.domain.model.Vendedor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VendaDTO implements Serializable {

    private Long id;

    private LocalDate dataVenda;

    private BigDecimal valor;

    @JsonProperty("vendedor")
    @JsonIgnoreProperties(value = {"totalVendas", "mediaVendas"})
    private VendedorDTO vendedorDTO;

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.dataVenda = venda.getDataVenda();
        this.valor = venda.getValor();
        this.vendedorDTO = new VendedorDTO(venda.getVendedor());
    }
}
