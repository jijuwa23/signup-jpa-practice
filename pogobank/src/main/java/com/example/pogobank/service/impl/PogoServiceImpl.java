package com.example.pogobank.service.impl;

import com.example.pogobank.dto.UserRequest;
import com.example.pogobank.dto.UserResponse;
import com.example.pogobank.entity.UserEntity;
import com.example.pogobank.enums.UserStatus;
import com.example.pogobank.repository.UserRepository;
import com.example.pogobank.service.PogoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import util.DateUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class PogoServiceImpl implements PogoService {
    private final UserRepository userRepository;

    @Override
    public UserResponse signUp(UserRequest userRequest) {
        UserEntity userEntity = parseUser(userRequest);
        userRepository.save(userEntity);
        return parseResponse(userEntity);
    }

    @Override
    public List<UserEntity> getActiveAccounts() {
        return userRepository.getActiveAccounts();
    }

    private UserResponse parseResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .balance(userEntity.getBalance())
                .status(userEntity.getStatus())
                .acctOpeningDate(userEntity.getAcctOpeningDate())
                .accountNumber(userEntity.getAccountNumber())
                .build();

    }

    private synchronized Long generateAccountNumber(){
        Long acctNumber;
        do {
            acctNumber = new Random().nextLong(100000000);
        } while (userRepository.existsById(acctNumber));
        return acctNumber;
    }



    private UserEntity parseUser(UserRequest userRequest) {
        return UserEntity.builder()
                .fullName(userRequest.getFullName())
                .address(userRequest.getAddress())
                .emailAddress(userRequest.getEmailAddress())
                .mobileNumber(userRequest.getMobileNumber())
                .balance(new BigDecimal("0.00"))
                .accountNumber(generateAccountNumber())
                .acctOpeningDate(DateUtil.getCurrentDateTime())
                .status(UserStatus.ACTIVE)
                .build();
    }

}
