package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.request.UserRequest;
import com.springboot.elasticsearch.response.UserResponse;

import java.util.List;

public interface UserService {
    String create(UserRequest userRequest);

    List<UserResponse> getAll();

    UserResponse getById(Long id);

    String update(UserRequest userRequest);

    String deleteById(Long id);
}
