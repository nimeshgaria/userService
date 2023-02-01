package com.microservice.userservice.service;

import com.microservice.userservice.model.Users;
import com.microservice.userservice.request.UserRequest;
import com.microservice.userservice.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String addUsers(UserRequest userRequest);
    List<Users> getUsers();
    UserResponse getUser(String email);
    Users updateUserDetails(String email , UserRequest userRequest);
    Users deleteUser(String email);


}
