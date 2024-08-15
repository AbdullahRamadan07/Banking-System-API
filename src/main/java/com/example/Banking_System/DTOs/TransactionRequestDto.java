package com.example.Banking_System.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
