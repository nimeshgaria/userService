package com.microservice.userservice.service.serviceImpl;

import com.microservice.userservice.model.Users;
import com.microservice.userservice.repository.UserRepository;
import com.microservice.userservice.request.UserRequest;
import com.microservice.userservice.response.UserResponse;
import com.microservice.userservice.service.UserService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public String addUsers(UserRequest userRequest){
        Users users = userRepository.findByEmail(userRequest.getEmail());
        if(users == null){
             Users u = Users.builder()
                    .active(userRequest.isActive())
                    .createdDateTime(userRequest.getCreatedDateTime())
                    .email(userRequest.getEmail())
                    .failedLoginAttempts(userRequest.getFailedLoginAttempts())
                    .firstName(userRequest.getFirstName())
                    .lastName(userRequest.getLastName())
                    .password(userRequest.getPassword())
                    .username(userRequest.getUsername())
                    .build();
            userRepository.save(u);
            return "User added";
        }
        return "Not added as user already present";
    }

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUser(String email) {
        Users users  = userRepository.findByEmail(email);
        if(users != null){

            UserResponse userResponse = UserResponse.builder()
                    .active(users.isActive())
                    .createdDateTime(users.getCreatedDateTime())
                    .email(users.getEmail())
                    .failedLoginAttempts(users.getFailedLoginAttempts())
                    .firstName(users.getFirstName())
                    .lastName(users.getLastName())
                    .username(users.getUsername())
                    .build();
            return userResponse;
        }
        return null;
    }

    // flow and without delete it is overwriting how ?
    @Override
    public Users updateUserDetails(String email, UserRequest userRequest) {
        Users users = userRepository.findByEmail(email);

        Users updatedUser = Users.builder()
                .active(userRequest.isActive())
                .username(userRequest.getUsername())
                .createdDateTime(userRequest.getCreatedDateTime())
                .password(userRequest.getPassword())
                .firstName(userRequest.getFirstName())
                .failedLoginAttempts(userRequest.getFailedLoginAttempts())
                .email(userRequest.getEmail())
                .lastName(userRequest.getLastName())
                .build();
        userRepository.delete(users);
        userRepository.save(updatedUser);
        return updatedUser;
    }

    @Override
    public Users deleteUser(String email) {
        Users users = userRepository.findByEmail(email);
        userRepository.delete(users);

        return  users;
    }
}
