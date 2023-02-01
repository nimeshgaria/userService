package com.microservice.userservice.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private int failedLoginAttempts;

    private String  createdDateTime;
    private boolean active;
}
