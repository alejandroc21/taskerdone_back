package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.dto.ProjectDetailsDTO;
import com.alejandroct.taskerdone.enums.MemberRole;

import java.util.List;

public interface IProjectService {
    List<ProjectDTO> projectsListByUser(String authHeader);

    ProjectDTO saveProject(ProjectDTO projectDTO, String authHeader);

    List<ProjectDTO> projectsListByMembership(String authHeader, MemberRole role);

    ProjectDetailsDTO findProjectByIdAndUser(long projectId, String authHeader);
}
