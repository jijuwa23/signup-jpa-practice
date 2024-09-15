package com.example.pogobank.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String fullName;
    private String mobileNumber;
    private String address;
    private String emailAddress;
}
