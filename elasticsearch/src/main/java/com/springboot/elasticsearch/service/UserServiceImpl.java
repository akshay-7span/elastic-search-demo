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
import java.util.Optional;

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

    @Override
    public List<UserResponse> getAll() {

        Iterator<UserEntity> userEntityIterator = userRepository.findAll().iterator();
        List<UserResponse> userResponseList = new ArrayList<>();
        UserResponse userResponse = null;

        while (userEntityIterator.hasNext()) {
            userResponse = userMapper.userEntityToUserResponse(userEntityIterator.next());
            userResponseList.add(userResponse);
        }

        return userResponseList;
    }

    @Override
    public UserResponse getById(Long id){
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);

        if (userEntityOptional.isPresent()){
            UserResponse userResponse = userMapper.userEntityToUserResponse(userEntityOptional.get());
            return userResponse;
        }

        return null;
    }

    @Override
    public String update(UserRequest userRequest) {

        Optional<UserEntity> userEntityOptional = userRepository.findById(userRequest.getId());

        if (userEntityOptional.isPresent()){
            UserEntity userEntity = userMapper.userRequestToUserEntity(userRequest);
            userRepository.save(userEntity);
            return "User updated successfully.";
        }
        return "There is no such user.";
    }

    @Override
    public String deleteById(Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User deleted successfully.";
        }
        return "There is no such user.";
    }


}
