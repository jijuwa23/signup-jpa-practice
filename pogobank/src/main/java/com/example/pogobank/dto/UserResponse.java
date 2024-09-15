package com.example.pogobank.dto;

import com.example.pogobank.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long accountNumber;
    private BigDecimal balance;
    private UserStatus status;
    private String acctOpeningDate;
}
