package com.example.pogobank.entity;

import com.example.pogobank.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USERS")
public class UserEntity {
    @Id
    private Long accountNumber;

    private String fullName;

    private String mobileNumber;

    private String address;

    private String emailAddress;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String acctOpeningDate;
}
