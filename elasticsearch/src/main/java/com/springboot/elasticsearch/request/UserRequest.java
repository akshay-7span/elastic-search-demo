package com.springboot.elasticsearch.request;

import lombok.Data;

@Data
public class UserRequest {

    private Long id;

    private String name;

    private String city;

    private String email;

    private Long phoneNo;
}
