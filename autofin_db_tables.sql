DROP DATABASE IF EXISTS autofin;

-- CRIAÇÃO DO BANCO DE DADOS --

CREATE DATABASE autofin;
USE autofin;

-- CRIAÇÃO DAS TABELAS DO DIAGRAMA ER --
-- CRIAÇÃO DA TABELA CLIENTE --

CREATE TABLE cliente 
(
id_cliente INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(25),
CPF VARCHAR(20),
RG VARCHAR(20),
endereco VARCHAR(45),
telefone VARCHAR(11),
celular VARCHAR(12),
PRIMARY KEY (id_cliente)
);

SELECT * FROM cliente;

-- CRIAÇÃO DA TABELA FORNECEDOR --

CREATE TABLE fornecedor 
(
id_fornecedor INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(45),
cnpj VARCHAR(14),
endereco VARCHAR(45),
telefone INT,
PRIMARY KEY (id_fornecedor)
);

SELECT * FROM fornecedor;

-- CRIAÇÃO DA TABELA PRODUTOS --

CREATE TABLE produtos
(
id_produtos INT NOT NULL AUTO_INCREMENT,
fornecedor_id INT,
nome VARCHAR(45),
quantidade INT,
valor DECIMAL(9,2),
data DATE,
PRIMARY KEY (id_produtos),
FOREIGN KEY (fornecedor_id) REFERENCES fornecedor (id_fornecedor)
);

SELECT * FROM produtos;

-- CRIAÇÃO DA TABELA carro --

CREATE TABLE carro
(
id_carro INT NOT NULL AUTO_INCREMENT,
modelo VARCHAR(45),
marca VARCHAR(45),
combustivel VARCHAR(12),
placa VARCHAR(7),
quilometragem INT,
cliente_id INT,
PRIMARY KEY (id_carro),
FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente)
);

SELECT * FROM carro;

-- CRIAÇÃO DA TABELA ORÇAMENTO --

CREATE TABLE orcamento
(
id_orcamento INT NOT NULL AUTO_INCREMENT,
servico VARCHAR(60),
quantidade INT,
valor DECIMAL(9,2),
produto_id INT,
cliente VARCHAR(50),
carro VARCHAR(10),
PRIMARY KEY (id_orcamento),
FOREIGN KEY (produto_id) REFERENCES produtos(id_produtos)
);

SELECT * FROM orcamento;

