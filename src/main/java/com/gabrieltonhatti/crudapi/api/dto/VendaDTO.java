package com.gabrieltonhatti.crudapi.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VendaDTO implements Serializable {

    private Long id;
    private Date dataVenda;
    private BigDecimal valor;
    @JsonIgnoreProperties(value = {"totalVendas", "mediaVendas"})
    private VendedorDTO vendedorDTO;

}
