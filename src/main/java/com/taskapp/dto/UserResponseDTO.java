package com.taskapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to return safe and public user information to the client.
 * It intentionally excludes sensitive fields such as password.
 */
@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
}