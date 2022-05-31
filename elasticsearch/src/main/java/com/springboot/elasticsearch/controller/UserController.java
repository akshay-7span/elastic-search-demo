package com.springboot.elasticsearch.controller;

import com.springboot.elasticsearch.request.UserRequest;
import com.springboot.elasticsearch.response.UserResponse;
import com.springboot.elasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String create(@RequestBody UserRequest userRequest){
        return userService.create(userRequest);
    }

    @GetMapping
    public List<UserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping
    public String update(@RequestBody UserRequest userRequest){
        return userService.update(userRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
