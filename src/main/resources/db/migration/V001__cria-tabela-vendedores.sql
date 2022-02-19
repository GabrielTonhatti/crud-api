CREATE TABLE vendedores
(
    id                   SERIAL      NOT NULL,
    nome                 VARCHAR(60) NOT NULL,
    total_vendas         BIGINT      NOT NULL,
    media_vendas_diarias DECIMAL(10,2)      NOT NULL,
    PRIMARY KEY (id)
);