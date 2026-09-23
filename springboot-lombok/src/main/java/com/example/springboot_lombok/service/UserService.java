package com.example.springboot_lombok.service;

import com.example.springboot_lombok.dto.UserDTO;
import com.example.springboot_lombok.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long userId);
}
