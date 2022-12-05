DROP DATABASE IF EXISTS LP2A4;

CREATE DATABASE IF NOT EXISTS LP2A4;

USE LP2A4;

CREATE TABLE IF NOT EXISTS Disciplina (
    idDisciplina INTEGER AUTO_INCREMENT,
    sigla VARCHAR(200) NOT NULL UNIQUE,
    nome VARCHAR(200) NOT NULL UNIQUE,
    semestre INTEGER NOT NULL,
    PRIMARY KEY (idDisciplina)
);

CREATE TABLE IF NOT EXISTS Aluno (
    matricula INTEGER,
    nome VARCHAR(200) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(11) NOT NULL UNIQUE,
    responsavel VARCHAR(200) NOT NULL,
    semestre INTEGER NOT NULL,
    PRIMARY KEY (matricula)
);

CREATE TABLE IF NOT EXISTS Disciplina_Aluno (
    idDisciplinaAluno INTEGER AUTO_INCREMENT,
    matricula INTEGER NOT NULL,
    idDisciplina INTEGER NOT NULL,
    PRIMARY KEY (idDisciplinaAluno),
    FOREIGN KEY (matricula) REFERENCES Aluno(matricula),
    FOREIGN KEY (idDisciplina) REFERENCES Disciplina(idDisciplina)
);

INSERT INTO Disciplina(sigla, nome, semestre) VALUES
	("ES1A1", "Engenharia de Software 1", 1),
	("LG1A1", "Lógica de Programação 1", 1),
	("OACA1", "Organização e Arquitetura de Computadores", 1),
	("ADEA1", "Administração de Empresas", 1),
	("PTAA1", "Produção de Textos Acadêmico-Profissionais", 1),
	("PFDA1", "Práticas e Ferramentas de Desenvolvimento de Software", 1),
	("MATAI", "Matemática para Informática", 1),
	("RHUA1", "Recursos Humanos em Tecnologia da Informação", 1),

	("ES2A2", "Engenharia de Software II", 2),
	("LG2A2", "Lógica de Programação 11", 2),
	("EDDA2", "Estrutura de Dados", 2),
	("BD1A2", "Banco de Dados 1", 2),
	("S0PA2", "Sistemas Operacionais", 2),

	("ES3A3", "Engenharia de Software III", 3),
	("LP1A3", "Linguagem de Programação 1", 3),
	("BD2A3", "Banco de Dados II", 3),
	("REDA3", "Redes de Computadores", 3),
	("DW1A3", "Desenvolvimento Web I", 3),
	("EMPA3", "Empreendedorismo", 3),

	("ES4A4", "Engenharia de Software IV", 4),
	("LP2A4", "Linguagem de Programação II", 4),
	("SESA4", "Serviços e Servidores de Rede", 4),
	("SEGA4", "Segurança da Informação", 4),
	("DW2A4", "Desenvolvimento Web II", 4),
	("GPRA4", "Gestão de Projetos", 4);

SELECT * FROM Disciplina ORDER BY semestre;

INSERT INTO Aluno(matricula, nome, cpf, telefone, responsavel, semestre) VALUES 
    (1, "Miguel da Silva", "97577349852", "11911111101", "Maria da Silva", 1),
    (2, "Alice dos Santos", "74692755849", "11911111102", "José dos Santos", 1),
    (3, "Arthur de Oliveira", "88620164848", "11911111103", "Ana de Oliveira", 2),
    (4, "Sophia Souza", "62569951803", "11911111104", "Antônio Souza", 2),
    (5, "Davi Rodrigues", "53109041820", "11911111105", "Juliana Rodrigues", 3),
    (6, "Laura da Silva", "13584648807", "11911111106", "Francisco da Silva", 3),
    (7, "Bernardo de Oliveira", "14124683880", "11911111107", "Patrícia de Oliveira", 4),
    (8, "Sophia Ferreira", "78667609854", "11911111108", "João Ferreira", 4),
    (9, "Gabriel Alves", "26119652850", "11911111109", "Adriana Alves", 5),
    (10, "Helena Pereira", "34263308816", "11911111110", "Carlos Pereira", 5),
    (11, "Pedro Ferreira", "79495027896", "11911111111", "Aline Ferreira", 6),
    (12, "Isabella Lima", "92869071841", "11911111112", "Rafael Lima", 6);

SELECT * FROM ALUNO;

SELECT * FROM DISCIPLINA_ALUNO ORDER BY matricula;
