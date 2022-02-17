CREATE TABLE vendas
(
    id            SERIAL    NOT NULL,
    data_venda    TIMESTAMP NOT NULL,
    valor         BIGINT    NOT NULL,
    vendedor_id   INT       NOT NULL,
    vendedor_nome VARCHAR(60),

    PRIMARY KEY (id),
    CONSTRAINT fk_vendedores FOREIGN KEY (vendedor_id) REFERENCES vendedores (id)
);