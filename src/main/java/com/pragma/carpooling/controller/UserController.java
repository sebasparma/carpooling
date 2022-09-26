package com.pragma.carpooling.controller;

import com.pragma.carpooling.dto.UserDTO;
import com.pragma.carpooling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody Optional<UserDTO> userDTO) {

        if (userDTO.isEmpty())
            return new ResponseEntity<>("Data not provided", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(userService.saveUser(userDTO.get()), HttpStatus.OK);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<Object> findByEmail(@RequestParam Optional<String> email) {
        if (email.isEmpty())
            return new ResponseEntity<>("Email not provided", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(userService.findByEmail(email.get()), HttpStatus.OK);
    }

}
