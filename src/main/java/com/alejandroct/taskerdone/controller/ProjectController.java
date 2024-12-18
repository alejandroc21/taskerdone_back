package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectService projectService;


}
