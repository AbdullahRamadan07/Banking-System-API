package com.example.Banking_System.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionAmountRequestDto {
    private Long accountId;
    private BigDecimal amount;
}
