CREATE TABLE vendas
(
    id          SERIAL       NOT NULL,
    data_venda  VARCHAR(255) NOT NULL,
    valor       BIGINT       NOT NULL,
    vendedor_id INT          NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_vendedores FOREIGN KEY (vendedor_id) REFERENCES vendedores (id)
);