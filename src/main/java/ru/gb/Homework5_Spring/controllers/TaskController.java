package ru.gb.Homework5_Spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.Homework5_Spring.models.Task;
import ru.gb.Homework5_Spring.models.TaskStatus;
import ru.gb.Homework5_Spring.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")

public class TaskController {
    @Autowired
    private TaskService service;
     @RequestMapping(value = "/add", method = RequestMethod.POST)
     public ResponseEntity<Task> addTask(@RequestBody Task task){
         if(task == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

         } service.addTask(task);
         return new ResponseEntity<>(task, HttpStatus.CREATED);
     }

     @RequestMapping(value = "", method = RequestMethod.GET)
     public ResponseEntity <List <Task>> getAllTask(){
         List<Task> tasks = service.getAllTasks();
         return new ResponseEntity<>(tasks, HttpStatus.OK);
     }

     @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
     public ResponseEntity <List <Task>> getByStatus(@PathVariable("status") TaskStatus taskStatus){
         List <Task> list = service.getTasksByStatus(taskStatus);
         return new ResponseEntity<>(list, HttpStatus.OK);
     }

     @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
     public ResponseEntity <Task> update(@PathVariable("id") int id, @RequestBody TaskStatus taskStatus){
         service.updateStatusTask(id, taskStatus);
         return new ResponseEntity<>(service.getTaskById(id), HttpStatus.OK);

     }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity <Task> delete(@PathVariable("id") int id){
         Task task = service.getTaskById(id);
         service.deleteTask(id);
         return new ResponseEntity<>(task, HttpStatus.NO_CONTENT);

    }




}
