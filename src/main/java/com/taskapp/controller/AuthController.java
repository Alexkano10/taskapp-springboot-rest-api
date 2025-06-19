package com.taskapp.controller;

import com.taskapp.dto.UserLoginDTO;
import com.taskapp.dto.UserRegisterDTO;
import com.taskapp.dto.UserResponseDTO;
import com.taskapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for user authentication (register and login).
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    /**
     * Registers a new user. Validates input and returns public user data.
     *
     * @param registerDTO input data from client
     * @return UserResponseDTO
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegisterDTO registerDTO) {
        UserResponseDTO response = userService.register(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * Authenticates user credentials and returns confirmation.
     *
     * @param loginDTO email and password
     * @return login result or future token
     */
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDTO loginDTO) {
        String result = userService.login(loginDTO);
        return ResponseEntity.ok(result);
    }
}