package com.example.jobby.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobby.DTO.ApiResponse;
import com.example.jobby.DTO.LoginDTO;
import com.example.jobby.Entity.User;
import com.example.jobby.Service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<ApiResponse<User>> loginUser(@RequestBody LoginDTO details){
        User usr = userService.LoginUser(details);
        ApiResponse<User> response = new ApiResponse<>();
        response.setData(usr);
        response.setMessage("User Login successfull");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/singup")
    public ResponseEntity<ApiResponse<User>> SingUp(@RequestBody User details){
        User usr = userService.signUp(details);
        ApiResponse<User> response = new ApiResponse<>();
        response.setData(usr);
        response.setMessage("User Login successfull");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // get user details 
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<User>> getUserbyId(@PathVariable Long userId){
        User usr = userService.getUserById(userId);
        ApiResponse<User> response = new ApiResponse<>();
        response.setData(usr);
        response.setMessage("User Login successfull");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
