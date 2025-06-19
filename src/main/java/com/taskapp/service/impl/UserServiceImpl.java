package com.taskapp.service.impl;

import com.taskapp.dto.UserRegisterDTO;
import com.taskapp.dto.UserLoginDTO;
import com.taskapp.dto.UserResponseDTO;
import com.taskapp.entity.User;
import com.taskapp.repository.UserRepository;
import com.taskapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of UserService. Handles user registration and login logic.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new user. Validates uniqueness and encrypts password before saving.
     *
     * @param userDTO user registration input
     * @return public user info
     */
    @Override
    @Transactional
    public UserResponseDTO register(UserRegisterDTO userDTO) {
        // Check if email or username already exists
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Username is already taken");
        }

        // Build new user and encrypt password
        User user = User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();

        // Save to database
        User savedUser = userRepository.save(user);

        // Return response DTO
        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

    @Override
    public String login(UserLoginDTO loginDTO) {
        // Search user by email
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Check password
        boolean passwordMatch = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
        if (!passwordMatch) {
            throw new RuntimeException("Invalid email or password");
        }

        // If valid, return a success message (token will come later)
        return "Login successful for user: " + user.getUsername();
    }
}
