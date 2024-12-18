package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.dto.UserDTO;
import com.alejandroct.taskerdone.model.User;

public interface IUserService {
    boolean userExist(String email);

    UserDTO saveUser(User user);

    User findUserByEmail(String email);

    UserDTO findUserDTObyEmail(String email);
}
