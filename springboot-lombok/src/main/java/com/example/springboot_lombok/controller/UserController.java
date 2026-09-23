package com.example.springboot_lombok.controller;

import com.example.springboot_lombok.dto.UserDTO;
import com.example.springboot_lombok.entity.User;
import com.example.springboot_lombok.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // create user REST API
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId){
        UserDTO getUser = userService.getUserById(userId);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> getAllUsers = userService.getAllUsers();
        return new ResponseEntity<>(getAllUsers, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long userId){
        UserDTO updateuser = userService.updateUser(userDTO);
        return new ResponseEntity<>(updateuser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }
}
