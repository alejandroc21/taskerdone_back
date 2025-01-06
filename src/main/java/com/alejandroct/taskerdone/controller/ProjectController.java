package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.dto.ProjectDetailsDTO;
import com.alejandroct.taskerdone.enums.MemberRole;
import com.alejandroct.taskerdone.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectService projectService;

    @GetMapping("/list-by-user")
    public ResponseEntity<List<ProjectDTO>> projectsListByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader){
        return ResponseEntity.ok(this.projectService.projectsListByUser(authHeader));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProjectDTO>> projectsListByMembership(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
                                                                     @RequestParam(required = false) MemberRole role){

        return ResponseEntity.ok(this.projectService.projectsListByMembership(authHeader, role));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDetailsDTO> findProjectByIdAndUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
                                                                    @PathVariable long projectId){
        return ResponseEntity.ok(this.projectService.findProjectByIdAndUser(projectId,authHeader));
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> saveProject(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
                                                  @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(this.projectService.saveProject(projectDTO, authHeader), HttpStatus.CREATED);
    }
}
