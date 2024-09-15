package com.example.pogobank.controller;

import com.example.pogobank.dto.UserRequest;
import com.example.pogobank.dto.UserResponse;
import com.example.pogobank.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PogoAPI {

    ResponseEntity<UserResponse> signUp(UserRequest userRequest);

    List<UserEntity> getActiveAccounts();
}
