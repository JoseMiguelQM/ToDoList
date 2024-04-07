package com.example.Roteiro01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Roteiro01.entity.Task;
public interface TaskRepository extends JpaRepository<Task, Long> {

}
