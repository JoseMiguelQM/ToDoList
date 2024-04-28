package com.example.Roteiro01.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Todos os detalhes sobre uma tarefa. ")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(name = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    @Size(min = 10, message = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    private String description;

    private Boolean completed;

    // Novos atributos
    private String type;
    private String priority;
    private java.sql.Date deadlineDate; // Para tarefas do tipo Data
    private Integer deadlineDays; // Para tarefas do tipo Prazo

    // Construtor com todos os atributos
    public Task(String description, String type, String priority, java.sql.Date deadlineDate, Integer deadlineDays) {
        this.description = description;
        this.type = type;
        this.priority = priority;
        this.deadlineDate = deadlineDate;
        this.deadlineDays = deadlineDays;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", completed=" + completed +
                ", type=" + type + ", priority=" + priority + ", deadlineDate=" + deadlineDate +
                ", deadlineDays=" + deadlineDays + "]";
    }
}
