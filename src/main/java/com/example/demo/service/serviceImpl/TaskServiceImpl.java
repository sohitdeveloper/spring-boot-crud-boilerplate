package com.example.demo.service.serviceImpl;

import com.example.demo.dao.TaskDao;
import com.example.demo.dto.TaskDto;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskDto updateTask(String userId, TaskDto taskDto) {
        return null;
    }

    @Override
    public List<TaskDto> getTasks() {
        return null;
    }

    @Override
    public void deleteTask(String id) {

    }
}
