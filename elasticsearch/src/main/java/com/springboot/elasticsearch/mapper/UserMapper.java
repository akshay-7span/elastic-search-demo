package com.springboot.elasticsearch.mapper;

import com.springboot.elasticsearch.entity.UserEntity;
import com.springboot.elasticsearch.request.UserRequest;
import com.springboot.elasticsearch.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse userEntityToUserResponse(UserEntity userEntity);

    UserEntity userRequestToUserEntity(UserRequest userRequest);


}
