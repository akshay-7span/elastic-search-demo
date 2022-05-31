package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.request.UserRequest;

public interface UserService {
    String create(UserRequest userRequest);
}
