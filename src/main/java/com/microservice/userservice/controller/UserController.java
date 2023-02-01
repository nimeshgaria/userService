package com.microservice.userservice.controller;

import com.microservice.userservice.model.Users;
import com.microservice.userservice.request.UserRequest;
import com.microservice.userservice.response.BaseResponse;
import com.microservice.userservice.response.UserResponse;
import com.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users/add")
    public ResponseEntity<BaseResponse> addUsers(@RequestBody UserRequest userRequest){
        String users = userService.addUsers(userRequest);
        BaseResponse baseResponse = new BaseResponse(100, users);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/users/")
    public ResponseEntity<BaseResponse> getAllUsers(){
        List<Users> users = userService.getUsers();
        BaseResponse baseResponse = new BaseResponse(200, users);
        return new ResponseEntity<BaseResponse>(baseResponse,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/users/{email}/")
    public ResponseEntity<BaseResponse> getUser(@PathVariable String email){
        UserResponse userResponse  = userService.getUser(email);
        BaseResponse  baseResponse = new BaseResponse(200, userResponse);

        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(200));
    }

    // doubt in serviceimpls
    @PutMapping("/user/update/{email}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable String email, @RequestBody UserRequest userRequest){
        Users users = userService.updateUserDetails(email, userRequest);
        BaseResponse  baseResponse = new BaseResponse(200, users);
        return new ResponseEntity<>(baseResponse,HttpStatusCode.valueOf(200));


    }
    @DeleteMapping("/user/delete/{email}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable String email){
        Users  users = userService.deleteUser(email);
        BaseResponse baseResponse = new BaseResponse(200, users);
        return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(200));
    }
}
