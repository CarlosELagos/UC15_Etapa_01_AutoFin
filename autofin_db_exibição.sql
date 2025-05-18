-- EXIBIÇÃO DOS DADOS CONTIDOS NAS TABELAS

-- exibição de todos os dados --
SELECT * FROM carro;
SELECT * FROM cliente;
SELECT * FROM fornecedor;
SELECT * FROM orcamento;
SELECT * FROM produtos;

-- BUSCA POR REGISTRO EXPECIFICO COM CLAUSULA WHERE

-- exibição dos carros cadastrados da Volkswagem --
SELECT id_carro,modelo FROM carro WHERE marca = 'vw';

-- EDIÇÃO DE DADOS CONTINOS NAS TABELAS COM UPDATE --

UPDATE cliente SET endereco = 'rua nova 01' WHERE id_cliente = 1;
SELECT * FROM cliente;
UPDATE cliente SET telefone = '112365-8970' WHERE id_cliente = 2;
SELECT * FROM cliente;

-- EXCLUSÃO DE DADOS CONTIDOS NAS TABELAS COM DELETE --

DELETE FROM orcamento WHERE id_orcamento = 6;
SELECT * FROM orcamento;