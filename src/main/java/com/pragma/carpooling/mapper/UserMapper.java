package com.pragma.carpooling.mapper;

import com.pragma.carpooling.dto.UserDTO;
import com.pragma.carpooling.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
