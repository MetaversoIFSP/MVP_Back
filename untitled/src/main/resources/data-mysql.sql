INSERT INTO FAQ_SOLUTION
	(PERGUNTA, RELEVANCE_POINTS, RESPOSTA, ID_CATEGORIA_DOIS)
VALUES
	('Já verificou todos os cabos de energia até a tomada?', 2, 'Às vezes, algum cabo pode estar mau encaixado ou, até mesmo, totalmente fora do lugar. Tente verificar se algum cabo de energia está bem fixado. Tente tirar e colocar. Apenas não realize força para encaixa-los ou desencaixa-los.', 1),
	('Existe alguma luzinha acesa no monitor?', 15, 'Se não existir, verifique ser o botão de energia está aceso.', 1),
    ('O cabo do teclado está ligado?', 3, 'Verifique se o cabo do teclado está bem afixado.', 2),
    ('Seu teclado tem cabo?', 15, 'Verifique se as pilhas estão carregadas.', 2)
;

INSERT INTO FAQ_CATEGORIA_DOIS
	(ID_Categoria_Um, NOME, PONTOS_RELEVANCIA, URL_IMAGEM)
VALUES
	(1, 'COMPUTADOR', 12,'URL_TESTE'),
	(1, 'COMPUTADOR', 1, 'URL_TESTE2')
;

INSERT INTO FAQ_CATEGORIA_UM
	(NOME, PONTOS_RELEVANCIA, URL_IMAGEM)
VALUES
	('COMPUTADOR', 1,'URL_TESTE'),
    ('CELULAR', 2, 'URL_TESTE_CELULAR')
;
