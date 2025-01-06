package com.alejandroct.taskerdone.mapper;

import com.alejandroct.taskerdone.dto.*;
import com.alejandroct.taskerdone.model.*;

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
                project.getMembers().stream().map(Mappers::getMemberDTO).collect(Collectors.toList()),
                project.getCategories().stream().map(Mappers::getCategoryDTO).collect(Collectors.toList()),
                project.getTasks().stream().map(Mappers::getTaskDTO).collect(Collectors.toList())
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

    public static CategoryDTO getCategoryDTO(Category category){
        return new CategoryDTO(category.getId(), category.getName());
    }

    public static Category getCategory(CategoryDTO categoryDTO){
        return Category.builder()
                .id(categoryDTO.id())
                .name(categoryDTO.name())
                .build();
    }

    public static TaskDTO getTaskDTO(Task task){
        return new TaskDTO(task.getId(), task.getName());
    }

    public static Task getTask(TaskDTO taskDTO){
        return Task.builder()
                .id(taskDTO.id())
                .name(taskDTO.name())
                .build();
    }
}
