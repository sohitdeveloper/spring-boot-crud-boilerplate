package com.example.demo.service;

import com.example.demo.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);

    TaskDto updateTask(String userId, TaskDto taskDto);

    List<TaskDto> getTasks();

    void deleteTask(String id);
}
