package ru.gb.Homework5_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Homework5_Spring.models.Task;
import ru.gb.Homework5_Spring.models.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> getTasksByStatus(TaskStatus status);
    Task findById(int id);

}
