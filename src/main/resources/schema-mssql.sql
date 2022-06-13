IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'DBO' AND  TABLE_NAME = 'Student')
BEGIN
    CREATE TABLE Student (
        id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
        name VARCHAR(255),
        address VARCHAR(2047)
    );
END


IF OBJECT_ID(N'dbo.FaqCategoriaUm', N'U') IS NULL
BEGIN
    CREATE TABLE faq_categoria_UM (
        ID                Bigint NOT NULL IDENTITY(1,1) PRIMARY KEY,
        NOME              VARCHAR(127),
        URL_IMAGEM        VARCHAR(2047),
        PONTOS_RELEVANCIA INT
    );
END;


IF OBJECT_ID(N'dbo.FaqCategoriaDois', N'U') IS NULL
BEGIN
    CREATE TABLE faq_categoria_dois (
        ID              Bigint NOT NULL IDENTITY(1,1) PRIMARY KEY,
        NOME            VARCHAR(1023),
        URL_IMAGEM      VARCHAR(2047),
        ID_CategoriaUm  Bigint NOT NULL,
        PONTOS_RELEVANCIA INT
        CONSTRAINT FK_FaqCategoriaDois_FaqCategoriaum  FOREIGN KEY(ID_CategoriaUm) REFERENCES FaqCategoriaUm(ID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
    );
END;


IF OBJECT_ID(N'dbo.FaqSolution', N'U') IS NULL
BEGIN
    CREATE TABLE Faq_Solution (
        ID                  Bigint NOT NULL IDENTITY(1,1) PRIMARY KEY,
        PERGUNTA            VARCHAR(1023),
        RESPOSTA            VARCHAR(2047),
        PONTOS_RELEVANCIA   INT,
        ID_CategoriaDois    Bigint NOT NULL,
        CONSTRAINT FK_Solucao_FaqCategoriaDois  FOREIGN KEY(ID_CategoriaDois) REFERENCES FaqCategoriaDois(ID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
    );
END;
