USE autofin;

INSERT INTO cliente (nome,CPF,RG,endereco,telefone,celular) VALUES 
("maria","123","123","Rua rua","123","123"),
("João", "456", "456", "Avenida Brasil", "456", "456"),
("Ana", "789", "789", "Rua das Flores", "789", "789"),
("Pedro", "101", "101", "Praça Central", "101", "101"),
("Carla", "112", "112", "Alameda Verde", "112", "112"),
("Lucas", "131", "131", "Rua do Sol", "131", "131");

SELECT * FROM cliente;

INSERT INTO carro (modelo,marca,combustivel,placa,quilometragem) VALUES 
("Ford", "Fiesta", "Flex", "BBB1B11", 20500),
("Chevrolet", "Onix", "Gasolina", "CCC2C22", 15000),
("Honda", "Civic", "Híbrido", "DDD3D33", 32000),
("Toyota", "Corolla", "Etanol", "EEE4E44", 27000),
("Renault", "Kwid", "Gasolina", "FFF5F55", 9000);

SELECT * FROM carro;

INSERT INTO fornecedor (nome,cnpj,endereco,telefone) VALUES 
("Fornecedor A","12345678000199","Rua das Flores, 123",9876543),
("Fornecedor B","98765432000188","Avenida Central, 456",4567891),
("Fornecedor C","56789123000177","Praça do Sol, 789",1239874),
("Fornecedor D","34567890000166","Alameda das Árvores, 321",6543217);

SELECT * FROM fornecedor;

INSERT INTO produtos (nome,quantidade,valor,data) VALUES 
("Filtro de óleo", 10, 29.90, 20250519),
("Pastilha de freio", 15, 89.50, 20250518),
("Bateria", 5, 350.00, 20250517),
("Correia dentada", 8, 120.90, 20250516),
("Velas de ignição", 12, 45.75, 20250515);

SELECT * FROM produtos;