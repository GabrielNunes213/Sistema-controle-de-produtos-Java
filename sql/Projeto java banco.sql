show databases;

CREATE DATABASE	BancoProdutos;
use BancoProdutos;

CREATE TABLE produtos (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    preco VARCHAR(10) NOT NULL,
    quantidade INT NOT NULL
);

SELECT * FROM produtos;

# Facilitar ações
DROP TABLE produtos;
DROP DATABASE BancoProdutos;
commit;