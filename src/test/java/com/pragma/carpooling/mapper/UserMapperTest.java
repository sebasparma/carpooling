package com.pragma.carpooling.mapper;

import com.pragma.carpooling.dto.UserDTO;
import com.pragma.carpooling.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


public class UserMapperTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void userSimpleMapperTest(){
        User user = new User("User Name","User lastName", "320024234","User address", "user@email.com","UserPass");

        UserDTO userDTO = userMapper.userToUserDTO(user);
        Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
    }

    @Test
    public void userDTOSimpleMapperTest(){
        UserDTO userDTO = new UserDTO("User Name","User lastName", "320024234","User address", "user@email.com","UserPass");

        User user = userMapper.userDTOToUser(userDTO);
        Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
    }
}
