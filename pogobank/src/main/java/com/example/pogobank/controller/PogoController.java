package com.example.pogobank.controller;

import com.example.pogobank.dto.UserRequest;
import com.example.pogobank.dto.UserResponse;
import com.example.pogobank.entity.UserEntity;
import com.example.pogobank.service.PogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pogo")
public class PogoController implements PogoAPI {

    private final PogoService pogoService;

    @Override
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(pogoService.signUp(userRequest));
    }

    @Override
    @GetMapping("/accounts/active")
    public List<UserEntity> getActiveAccounts() {
        return pogoService.getActiveAccounts();
    }
}
