package com.springboot.elasticsearch.response;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String name;

    private String city;

    private String email;

    private Long phoneNo;
}
