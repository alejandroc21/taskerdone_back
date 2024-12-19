package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.constants.ExceptionMessages;
import com.alejandroct.taskerdone.dto.UserDTO;
import com.alejandroct.taskerdone.mapper.Mappers;
import com.alejandroct.taskerdone.model.User;
import com.alejandroct.taskerdone.repository.UserRepository;
import com.alejandroct.taskerdone.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Override
    public boolean userExist(String email) {
        return this.userRepository.findByEmail(email).isPresent();
    }

    @Override
    public UserDTO saveUser(User user) {
        return Mappers.getUserDTO(this.userRepository.save(user));
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessages.USER_NOT_FOUND));
    }

    @Override
    public UserDTO findUserDTObyEmail(String email) {
        return Mappers.getUserDTO(this.findUserByEmail(email));
    }
}
