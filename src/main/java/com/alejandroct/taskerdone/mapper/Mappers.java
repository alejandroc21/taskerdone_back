package com.alejandroct.taskerdone.mapper;

import com.alejandroct.taskerdone.dto.MemberDTO;
import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.dto.ProjectDetailsDTO;
import com.alejandroct.taskerdone.dto.UserDTO;
import com.alejandroct.taskerdone.model.Member;
import com.alejandroct.taskerdone.model.Project;
import com.alejandroct.taskerdone.model.User;

import java.util.stream.Collectors;

public class Mappers {

    public static UserDTO getUserDTO(User user){
        return new UserDTO(user.getName(), user.getEmail());
    }

    public static User getUser(UserDTO userDTO){
        return User.builder()
                .name(userDTO.name())
                .email(userDTO.email())
                .build();
    }

    public static ProjectDTO getProjectDTO(Project project){
        return new ProjectDTO(project.getId(), project.getName());
    }

    public static ProjectDetailsDTO getProjectDetails(Project project){
        return new ProjectDetailsDTO(
                project.getId(),
                project.getName(),
                project.getMembers().stream().map(Mappers::getMemberDTO).collect(Collectors.toList())
        );
    }

    public static Project getProject(ProjectDTO projectDTO){
        return Project.builder()
                .id(projectDTO.id())
                .name(projectDTO.name())
                .build();
    }

    public static MemberDTO getMemberDTO(Member member){
        return new MemberDTO(member.getId(), member.getRole(),Mappers.getUserDTO(member.getUser()));
    }
}
