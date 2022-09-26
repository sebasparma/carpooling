package com.pragma.carpooling.service;

import com.pragma.carpooling.dto.UserDTO;
import com.pragma.carpooling.entity.User;
import com.pragma.carpooling.factory.UserDataFactory;
import com.pragma.carpooling.mapper.UserMapper;
import com.pragma.carpooling.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @Test
    void simpleCorrectSaveUser() {
        UserDTO userDTO = UserDataFactory.getUserDTOFull();
        User userParameter = UserDataFactory.getUserFull();

        when(userMapper.userDTOToUser(any())).thenReturn(userParameter);
        when(userRepository.save(any(User.class))).thenReturn(userParameter);
        when(userMapper.userToUserDTO(any())).thenReturn(userDTO);

        userService.saveUser(userDTO);

        verify(userRepository).save(any(User.class));
    }

    @Test
    void findByEmailCorrect() {
        UserDTO userDTO = UserDataFactory.getUserDTOFull();

        when(userMapper.userToUserDTO(any())).thenReturn(userDTO);
        when(userRepository.findByEmail(anyString())).thenReturn(UserDataFactory.getUserFull());

        userService.findByEmail("user@email.com");

        verify(userRepository).findByEmail(anyString());
    }

    @Test
    void findByEmailReturnNull() {
        UserDTO userDTO = UserDataFactory.getUserDTOFull();

        when(userMapper.userToUserDTO(any())).thenReturn(userDTO);
        when(userRepository.findByEmail(anyString())).thenReturn(null);

        userService.findByEmail("user@email.com");

        verify(userRepository).findByEmail(anyString());
    }
}