package com.example.springboot_lombok.service;

import com.example.springboot_lombok.dto.UserDTO;
import com.example.springboot_lombok.entity.User;
import com.example.springboot_lombok.mapper.UserMapper;
import com.example.springboot_lombok.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        // convert UserDTO to User JPA entity
        User user = UserMapper.mapToUser(userDTO);

        User savedUser = userRepository.save(user);

        // convert User JPA entity to UserDTO
        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);
        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDTO(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
