package com.example.facebookClone.controller;

import com.example.facebookClone.entity.User;
import com.example.facebookClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody User user) {
        userService.signup(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody User user) {
//        userService.login(user);
//        return new ResponseEntity(HttpStatus.OK);
//    }



}
