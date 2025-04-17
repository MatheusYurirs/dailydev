CREATE TABLE daily_entry (
    id SERIAL PRIMARY KEY,
    data DATE,
    horas_estudadas INT,
    humor VARCHAR(255),
    tecnologias_estudadas TEXT,
    desafios TEXT,
    anotacoes TEXT,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
