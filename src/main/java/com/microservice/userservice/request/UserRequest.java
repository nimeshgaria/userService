package com.microservice.userservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String email;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int failedLoginAttempts;

    private String createdDateTime;
    private boolean active;

}
