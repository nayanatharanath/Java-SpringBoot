package com.example.springboot_lombok.mapper;

import com.example.springboot_lombok.dto.UserDTO;
import com.example.springboot_lombok.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDTO mapToUserDTO(User user);

    User mapToUser(UserDTO userDTO);
}
