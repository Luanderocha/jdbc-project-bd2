CREATE TABLE Arma(
	numeroDeSerie INTEGER,
	nome VARCHAR(100),
	marca VARCHAR(100),
	modelo VARCHAR(50),
	valor NUMERIC(10,2),
	estoque INTEGER,

	PRIMARY KEY (numeroDeSerie)
);

CREATE TABLE Usuario(
	id INTEGER,
	nome VARCHAR (100),
	cpf CHAR(11),
	email VARCHAR(100),
	telefone CHAR(14),
	PRIMARY KEY(id)
);

CREATE TABLE Venda(
	id Integer,
	numeroDeSerieArma INTEGER REFERENCES Arma (numeroDeSerie),
	idUsuario Integer REFERENCES Usuario(id),
	notaFiscal Integer,
	dataVenda Date,
	
	CONSTRAINT id_pk
		PRIMARY KEY(id)
);

CREATE OR REPLACE FUNCTION decrementarEstoque()
  RETURNS TRIGGER 
  LANGUAGE PLPGSQL
  AS
$$
BEGIN

	UPDATE Arma SET estoque = estoque - 1 
	WHERE new.numeroDeSerieArma = numeroDeSerie;

	RETURN NEW;
END;
$$

CREATE TRIGGER vendaRealizada
AFTER INSERT ON Venda
FOR EACH ROW
EXECUTE PROCEDURE decrementarEstoque();


CREATE OR REPLACE FUNCTION temEstoque()
  RETURNS TRIGGER 
  LANGUAGE PLPGSQL
  AS
$$
DECLARE 
	qtdItem INT;
BEGIN
	SELECT a.estoque INTO qtdItem FROM Arma a WHERE
	new.numeroDeSerieArma = a.numeroDeSerie;
	
	IF qtdItem > 1 THEN
	ELSIF qtdItem = 1 THEN
		RAISE NOTICE 'Última unidade da arma';
	ELSE
		RAISE EXCEPTION 'Não há mais unidades da arma';
	END IF;
	RETURN NEW;
END;

$$


CREATE TRIGGER temArmaEstoque
BEFORE INSERT ON Venda
FOR EACH ROW 
EXECUTE PROCEDURE temEstoque();
