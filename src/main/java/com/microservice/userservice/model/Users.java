package com.microservice.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Users {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    @JsonIgnore
    private String password;
    private int failedLoginAttempts;

    private String  createdDateTime;
    private boolean active;

}
