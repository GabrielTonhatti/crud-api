package com.gabrieltonhatti.crudapi.infrastructure.repository;

import com.gabrieltonhatti.crudapi.api.dto.VendedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VendedorRepositoryCustomImpl implements VendedorRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page<VendedorDTO> findAllPageable(Pageable page) {
        String sql = "SELECT a.* FROM (SELECT v.id, v.nome, COALESCE(AVG(v2.valor), 0) AS mediaVendas, " +
                "COALESCE(SUM(v2.valor), 0) AS totalVendas FROM vendedores AS v " +
                "        LEFT JOIN vendas v2 ON v.id = v2.vendedor_id  " +
                " GROUP BY v.id, v.nome  " +
                " ORDER BY v.id ASC) AS a LIMIT " + page.getPageSize() + " OFFSET " + page.getOffset();

        System.out.println(sql);

        List<VendedorDTO> vendedorDTO = jdbcTemplate.query(sql, new BeanPropertyRowMapper(VendedorDTO.class));

        return new PageImpl<VendedorDTO>(vendedorDTO, page, count());
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM vendedores", Integer.class);
    }
}
