package com.taskapp.service;

import com.taskapp.dto.UserLoginDTO;
import com.taskapp.dto.UserRegisterDTO;
import com.taskapp.dto.UserResponseDTO;

public interface UserService {

    /**
     * Registers a new user in the system.
     *
     * @param userDTO user registration input
     * @return basic info of the created user
     */
    UserResponseDTO register(UserRegisterDTO userDTO);

    /**
     * Authenticates a user with email and password.
     *
     * @param loginDTO login credentials
     * @return authentication response (e.g. token or message)
     */
    String login(UserLoginDTO loginDTO);
}
