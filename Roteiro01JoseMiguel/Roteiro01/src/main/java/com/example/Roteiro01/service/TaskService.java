package com.example.Roteiro01.service;

import com.example.Roteiro01.entity.Task;
import com.example.Roteiro01.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        // Pode adicionar lógica de validação ou processamento adicional aqui antes de salvar
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCompleted(updatedTask.getCompleted());
            existingTask.setType(updatedTask.getType()); // Adicionando o tipo de tarefa
            existingTask.setPriority(updatedTask.getPriority()); // Adicionando a prioridade
            existingTask.setDeadlineDate(updatedTask.getDeadlineDate()); // Adicionando a data de prazo
            existingTask.setDeadlineDays(updatedTask.getDeadlineDays()); // Adicionando os dias de prazo
            return taskRepository.save(existingTask);
        } else {
            // Lidar com o caso em que a tarefa com o ID fornecido não existe
            return null;
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task markTaskAsCompleted(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setCompleted(true);
            return taskRepository.save(task);
        } else {
            // Lidar com o caso em que a tarefa com o ID fornecido não existe
            return null;
        }
    }
}
