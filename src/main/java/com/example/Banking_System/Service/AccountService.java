package com.example.Banking_System.Service;


import com.example.Banking_System.DTOs.AccountDto;

import java.math.BigDecimal;

public interface AccountService {
    public AccountDto findAccountById(Long id);
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount);

}
