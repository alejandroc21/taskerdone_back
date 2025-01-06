package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.TaskRepository;
import com.alejandroct.taskerdone.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {
    private final TaskRepository taskRepository;
}
