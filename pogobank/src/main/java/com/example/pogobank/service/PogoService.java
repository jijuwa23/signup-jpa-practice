package com.example.pogobank.service;

import com.example.pogobank.dto.UserRequest;
import com.example.pogobank.dto.UserResponse;
import com.example.pogobank.entity.UserEntity;

import java.util.List;

public interface PogoService {
    UserResponse signUp(UserRequest userRequest);

    List<UserEntity> getActiveAccounts();
}
