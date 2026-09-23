package com.example.springboot_lombok.mapper;

import com.example.springboot_lombok.dto.UserDTO;
import com.example.springboot_lombok.entity.User;

public class UserMapper {

    // convert User JPA entity to UserDTO
    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    // convert UserDTO to User JPA Entity
    public static User mapToUser(UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
