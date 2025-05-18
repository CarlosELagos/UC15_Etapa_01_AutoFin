-- INSERÇÃO DOS DADOS NAS TABELAS 

-- Inserção de itens 
-- inserção dos dados dos clientes

INSERT INTO cliente 
(nome,cpf,rg,endereco,telefone)
VALUES
('Luca','12345678900','12345678-9','rua 1','11123456678'),
('Theo','23456789011','56789012-3','rua 2','tel 02'),
('Lara','34567890122','23456789-0','rua 3','tel 03'),
('Maya','45678901233','34567890-1','rua 4','tel 04'),
('Noah','56789012344','45678901-2','rua 5','tel 05');

SELECT * from cliente;

-- inserção dos dados dos carros

INSERT INTO carro
(modelo,marca,combustivel,placa,quilometragem,cliente_id)
VALUES
('Fox','VW','F','ABC1D23',43000,1),
('UP','VW','F','XYZ4E56',33000,2),
('Corolla','TOYOTA','F','JKL7M89',243000,3),
('PALIO','FIAT','G','QRS0T12',480000,4),
('CIVIC','HONDA','F','UVW3X45',187524,5);

SELECT * FROM carro;

-- alterando a tabela fornecedor para adequar as colunas

ALTER TABLE fornecedor MODIFY COLUMN cnpj VARCHAR(17);
ALTER TABLE fornecedor MODIFY COLUMN telefone VARCHAR(20);

-- insersão dos dados dos fornecedores

INSERT INTO fornecedor
(nome,cnpj,endereco,telefone)
VALUES
('SIGMA','123456789/0001-90','RUA 01','(11)6789-0123'),
('PEÇAS','23456789/0001-01','RUA 02','(11)2345-6789'),
('MERCADOCAR','34567890/0001-12','RUA 03','(11)3456-7890'),
('BERNA AUTO PEÇAS','45678901/0001-23','AV. BERNA-1453','(11)4567-8901'),
('MULTPEÇAS','56789012/0001-34','AV 04','(11)5678-9012');

SELECT * FROM fornecedor;

-- insersão dos produtos

INSERT INTO produtos
(fornecedor_id,nome,quantidade,valor,data)
VALUES
(1,'bieletas',2,15.60,'2024-08-08'),
(2,'bandejas',2,245.56,'2024-08-09'),
(3,'terminal de direção',3,145.50,'2024-08-20'),
(4,'filtro de oleo',1,45.60,'2024-08-24'),
(5,'filtro de ar',1,27.50,'2024-08-08'),
(5,'pastilha de freio',1,27.50,'2024-08-08');

SELECT * FROM produtos;

-- insersão dos orçamentos

INSERT INTO orcamento
(servico,data,valor,produto_id,carro_id)
VALUES
('troca de valvula bieletas',"2024-08-01",150.98,1,1),
('troca de bandeja',"2024-08-01",150.98,2,2),
('troca de terminal de direção',"2024-08-01",150.98,3,3),
('troca de filtro de oleo',"2024-08-01",150.98,4,4),
('troca de filtro de ar',"2024-08-01",150.98,5,5),
('troca de filtro de ar',"2024-08-01",150.98,5,5),
('troca de pastilha de freio',"2024-08-01",150.98,6,1);

SELECT * FROM orcamento;