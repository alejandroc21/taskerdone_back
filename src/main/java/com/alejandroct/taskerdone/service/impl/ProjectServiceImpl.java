package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl {
    private final ProjectRepository projectRepository;
}
