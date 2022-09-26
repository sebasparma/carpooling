package com.pragma.carpooling.service;

import com.pragma.carpooling.dto.UserDTO;
import com.pragma.carpooling.entity.User;
import com.pragma.carpooling.mapper.UserMapper;
import com.pragma.carpooling.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        return userMapper.userToUserDTO(userRepository.save(user));
    }

    public UserDTO findByEmail(String email) {
        return userMapper.userToUserDTO(userRepository.findByEmail(email));
    }

}
