INSERT INTO VACINACAO.PESSOA (NOME, DT_NASCIMENTO, SEXO, CPF, TIPO) VALUES ('LOUISI DALAZEN', '2003-10-29', 'F', '123.123.123-01', 3);
INSERT INTO VACINACAO.PESSOA (NOME, DT_NASCIMENTO, SEXO, CPF, TIPO) VALUES ('ARTUR NETO', '2002-03-08', 'M', '111.222.333-02', 2);
INSERT INTO VACINACAO.PESSOA (NOME, DT_NASCIMENTO, SEXO, CPF, TIPO) VALUES ('PATRICIA DALAZEN', '1969-7-24', 'F', '321.321.321-03', 1);

INSERT INTO VACINACAO.VACINA (NOME, PAIS_DE_ORIGEM, ESTAGIO_DA_PESQUISA, DT_INICIO_PESQUISA, ID_PESQUISADOR_RESPONSAVEL) VALUES ('SARAMPO','BRASIL', 3, '1960-10-01', 1);

INSERT INTO VACINACAO.VACINACAO (ID_PESSOA, ID_VACINA, REACAO, DT_APLICACAO) VALUES (1, 1, 5, '2004-02-01');

select * from vacinacao.pessoa where id_pessoa = 1;

SELECT * FROM VACINACAO.PESSOA;
SELECT * FROM VACINACAO.VACINA;
SELECT * FROM VACINACAO.VACINACAO;