CREATE TABLE IF NOT EXISTS Student (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(4096)
);

CREATE TABLE IF NOT EXISTS Faq_Categoria_Um (
    ID                Bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NOME              VARCHAR(127),
    URL_IMAGEM        VARCHAR(4096),
    PONTOS_RELEVANCIA INT
);

CREATE TABLE IF NOT EXISTS Faq_Categoria_Dois (
    ID              Bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NOME            VARCHAR(127),
    URL_IMAGEM      VARCHAR(4096),
    ID_CategoriaUm  Bigint NOT NULL,
    PONTOS_RELEVANCIA INT,
    FOREIGN KEY(ID_CategoriaUm) REFERENCES Faq_Categoria_Um(ID)
);


CREATE TABLE IF NOT EXISTS Faq_Solution (
    ID                  Bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PERGUNTA            VARCHAR(1024),
    RESPOSTA            VARCHAR(2048),
    PONTOS_RELEVANCIA   INT,
    ID_CategoriaDois    Bigint NOT NULL,
    FOREIGN KEY(ID_CategoriaDois) REFERENCES Faq_Categoria_Dois(ID)
);
