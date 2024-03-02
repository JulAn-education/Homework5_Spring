package ru.gb.Homework5_Spring.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.Homework5_Spring.models.Task;
import ru.gb.Homework5_Spring.models.TaskStatus;
import ru.gb.Homework5_Spring.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    public void addTask(Task task) {
        taskRepo.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepo.findById(id);
    }

    public void deleteTask(int id) {
        taskRepo.deleteById(id);
    }

    public boolean updateStatusTask(int id, TaskStatus status) {
        Task task = taskRepo.findById(id);
        if (task!= null) {

            task.setStatus(status);
            taskRepo.save(task);
            return true;
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepo.getTasksByStatus(status);
    }
}
