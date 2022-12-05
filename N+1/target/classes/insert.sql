INSERT INTO Proprietario(id, nome, cpf, telefone) VALUES (1, 'Miguel Silva', '11111111111', '11911111111');
INSERT INTO Proprietario(id, nome) VALUES (2, 'Helena Santos', '22222222222', '11911111112');
INSERT INTO Proprietario(id, nome) VALUES (3, 'Arthur Oliveira', '33333333333', '11911111113');
INSERT INTO Proprietario(id, nome) VALUES (4, 'Alice Souza', '44444444444', '11911111114');

INSERT INTO Veiculo(id, marca, modelo, cor, idProprietario) VALUES (1, 'Fiat', 'Cronos', 'Prata', 1);
INSERT INTO Veiculo(id, marca, modelo, cor, idProprietario) VALUES (2, 'Toyota', 'Yaris', 'Azil', 1);
INSERT INTO Veiculo(id, marca, modelo, cor, idProprietario) VALUES (3, 'Hyundai', 'HB20', 'Preto', 2);
INSERT INTO Veiculo(id, marca, modelo, cor, idProprietario) VALUES (4, 'Renault', 'Logan', 'Prata', 3);
INSERT INTO Veiculo(id, marca, modelo, cor, idProprietario) VALUES (5, 'Nissan', 'Leaf', 'Branco', 3);
INSERT INTO Veiculo(id, marca, modelo, cor, idProprietario) VALUES (6, 'Volkswagen', 'Gol', 'Vermelho', 4);