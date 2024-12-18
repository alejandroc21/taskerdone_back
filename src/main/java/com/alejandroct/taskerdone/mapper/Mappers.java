package com.alejandroct.taskerdone.mapper;

import com.alejandroct.taskerdone.dto.UserDTO;
import com.alejandroct.taskerdone.model.User;

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
}
