package com.gabrieltonhatti.crudapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vendas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private LocalDateTime dataVenda;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    @JsonIgnoreProperties(value = {"totalVendas", "mediaVendas"})
    private Vendedor vendedor;

}
