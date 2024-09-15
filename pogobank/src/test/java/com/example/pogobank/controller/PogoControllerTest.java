package com.example.pogobank.controller;

import com.example.pogobank.dto.UserRequest;
import com.example.pogobank.dto.UserResponse;
import com.example.pogobank.entity.UserEntity;
import com.example.pogobank.enums.UserStatus;
import com.example.pogobank.service.PogoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PogoControllerTest {
    private MockMvc mockMvc;

    @Mock
    private PogoService pogoService;

    @InjectMocks
    private PogoController pogoController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pogoController).build();
    }

    @Test
    void testSignUp() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setAddress("dears");
        userRequest.setMobileNumber("092131");
        userRequest.setFullName("Cris Miranda");
        userRequest.setEmailAddress("cris@gmail.com");

        UserResponse userResponse = new UserResponse();
        userResponse.setAccountNumber(Long.valueOf(12313124));
        userResponse.setBalance(new BigDecimal("1231.00"));
        userResponse.setStatus(UserStatus.ACTIVE);
        userResponse.setAcctOpeningDate("08/14/2024");

        when(pogoService.signUp(userRequest)).thenReturn(userResponse);

        mockMvc.perform(post("/pogo/signup")
                        .content(objectMapper.writeValueAsString(userRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(pogoService, times(1)).signUp(userRequest);
    }

    @Test
    void testGetAccounts() throws Exception {



        List<UserEntity> activeAccounts = Arrays.asList( UserEntity.builder()
                .accountNumber(Long.valueOf(4238866))
                .address("dears")
                .emailAddress("cris@gmail.com")
                .mobileNumber("09123123")
                .fullName("Cris Miranda")
                .acctOpeningDate("12312312")
                .status(UserStatus.ACTIVE)
                .balance(new BigDecimal("0.00"))
                .build());


        when(pogoService.getActiveAccounts()).thenReturn(activeAccounts);

        mockMvc.perform(get("/pogo/accounts/active")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(pogoService, times(1)).getActiveAccounts();
    }
}
