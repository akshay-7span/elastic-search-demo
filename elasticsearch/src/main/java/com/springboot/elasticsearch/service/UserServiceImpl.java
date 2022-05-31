package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.entity.UserEntity;
import com.springboot.elasticsearch.mapper.UserMapper;
import com.springboot.elasticsearch.repository.UserRepository;
import com.springboot.elasticsearch.request.UserRequest;
import com.springboot.elasticsearch.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String create(UserRequest userRequest) {

        // convert userRequest to Entity and store.
        UserEntity userEntity = userMapper.userRequestToUserEntity(userRequest);

        if(userRepository.save(userEntity) != null){
            return "User saved successfully.";
        }

        return "Something went wrong while saving user.";
    }
}
