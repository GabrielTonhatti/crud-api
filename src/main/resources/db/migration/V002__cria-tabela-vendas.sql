CREATE TABLE vendas
(
    id          SERIAL         NOT NULL,
    data_venda  DATE           NOT NULL,
    valor       DECIMAL(10, 2) NOT NULL,
    vendedor_id INT            NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_vendedores FOREIGN KEY (vendedor_id) REFERENCES vendedores (id)
);