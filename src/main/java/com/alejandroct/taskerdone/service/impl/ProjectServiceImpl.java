package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.constants.ExceptionMessages;
import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.dto.ProjectDetailsDTO;
import com.alejandroct.taskerdone.enums.MemberRole;
import com.alejandroct.taskerdone.mapper.Mappers;
import com.alejandroct.taskerdone.model.Member;
import com.alejandroct.taskerdone.model.Project;
import com.alejandroct.taskerdone.model.User;
import com.alejandroct.taskerdone.repository.ProjectRepository;
import com.alejandroct.taskerdone.service.IProjectService;
import com.alejandroct.taskerdone.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements IProjectService {
    private final ProjectRepository projectRepository;
    private final IUserService userService;

    @Override
    public List<ProjectDTO> projectsListByUser(String authHeader) {
        User user = this.userService.findUserByJwtToken(authHeader);
        return this.projectRepository.findByUserEmail(user.getEmail()).stream()
                .map(Mappers::getProjectDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> projectsListByMembership(String authHeader, MemberRole role) {
        User user = this.userService.findUserByJwtToken(authHeader);
        return this.projectRepository.findByUserId(user.getId(), role).stream()
                .map(Mappers::getProjectDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDetailsDTO findProjectByIdAndUser(long projectId, String authHeader) {
        User user = this.userService.findUserByJwtToken(authHeader);
        Optional<Project> project = this.projectRepository.findByIdAndUserId(projectId,user.getId());
        if(project.isEmpty()){
            throw new EntityNotFoundException(ExceptionMessages.PROJECT_NOT_FOUND);
        }
        return Mappers.getProjectDetails(project.get());
    }

    @Transactional
    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO, String authHeader) {
        User user = this.userService.findUserByJwtToken(authHeader);
        Project project = Mappers.getProject(projectDTO);
        project.setUser(user);
        this.projectRepository.save(project);

        Member member = Member.builder()
                .role(MemberRole.ADMIN)
                .project(project)
                .user(user)
                .build();

        ArrayList<Member> members = new ArrayList<>(List.of(member));
        project.setMembers(members);

        return Mappers.getProjectDTO(this.projectRepository.save(project));
    }
}
