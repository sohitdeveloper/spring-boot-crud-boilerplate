package com.example.demo.controller;

import com.example.demo.dto.TaskDto;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/task")
public class TaskEndpoint {
    @Autowired
    TaskService taskService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addTask(@RequestBody TaskDto taskDto) {
        Map<String, Object> response = new HashMap<>();
        TaskDto taskData = taskService.addTask(taskDto);
        response.put("message", "Task added successfully");
        response.put("data", taskData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/update/:id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTask(@PathVariable String userId, @RequestBody TaskDto taskDto) {
        Map<String, Object> response = new HashMap<>();
        TaskDto taskData = taskService.updateTask(userId, taskDto);
        response.put("message", "Task updated successfully");
        response.put("data", taskData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTasks() {
        Map<String, List<TaskDto>> response = new HashMap<>();
        List<TaskDto> taskData = taskService.getTasks();
        response.put("data", taskData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/delete/:id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTask(@PathVariable String id) {
        Map<String, String> response = new HashMap<>();
        taskService.deleteTask(id);
        response.put("message", "Task deleted successfully, " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
