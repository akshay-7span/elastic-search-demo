package com.springboot.elasticsearch.controller;

import com.springboot.elasticsearch.request.UserRequest;
import com.springboot.elasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String create(@RequestBody UserRequest userRequest){
        return userService.create(userRequest);
    }
}
