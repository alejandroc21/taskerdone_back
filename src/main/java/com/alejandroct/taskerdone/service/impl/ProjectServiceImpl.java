package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.ProjectRepository;
import com.alejandroct.taskerdone.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements IProjectService {
    private final ProjectRepository projectRepository;
}
