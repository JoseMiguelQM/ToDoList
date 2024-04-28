DROP TABLE IF EXISTS task;

CREATE TABLE task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(250) NOT NULL,
    type ENUM('Data', 'Prazo', 'Livre') NOT NULL,
    deadline_date DATE, -- Para tarefas do tipo Data
    deadline_days INT, -- Para tarefas do tipo Prazo
    priority ENUM('Alta', 'Média', 'Baixa') NOT NULL,
    completed BOOLEAN
);

INSERT INTO task (description, type, deadline_date, deadline_days, priority) VALUES
('Primeira tarefa', 'Data', '2024-04-30', NULL, 'Alta'),
('Segunda tarefa', 'Prazo', NULL, 5, 'Média'),
('Terceira tarefa', 'Livre', NULL, NULL, 'Baixa');
