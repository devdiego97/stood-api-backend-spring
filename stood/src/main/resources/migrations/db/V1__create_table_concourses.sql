CREATE TABLE concourses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- ID autoincrementável
    title VARCHAR(50) NOT NULL,           -- Título da vaga (5 a 50 caracteres)
    about TEXT NOT NULL,                  -- Descrição da vaga (100 a 4000 caracteres)
    city VARCHAR(50) NULL,  
    state VARCHAR(2) NULL,  
    numVacancies BIGINT NOT NULL,
    organization VARCHAR(50) NULL, 
    cover VARCHAR(255) NULL,                  -- Caminho da imagem de capa (opcional)
    average_salary DECIMAL(10, 2),       -- Salário médio (10 dígitos, 2 decimais)
    date_max_subscription DATE NOT NULL, -- Data máxima de inscrição
    status VARCHAR(50) NOT NULL,         -- Status do concurso (Enum)
    abrangency VARCHAR(50) NOT NULL,     -- Abrangência do concurso (Enum)
    level VARCHAR(50) NOT NULL,          -- Nível do concurso (Enum)
    date_min_subscription DATE NOT NULL, -- Data mínima de inscrição
    url_subscription VARCHAR(255) NOT NULL, -- URL de inscrição
    created_at DATETIME NOT NULL,        -- Data de criação (automática)
    updated_at DATETIME NOT NULL         -- Data de atualização (automática)
);