package com.example.Banking_System.Controllers;

import com.example.Banking_System.DTOs.AccountDto;
import com.example.Banking_System.DTOs.TransactionAmountRequestDto;
import com.example.Banking_System.DTOs.TransactionRequestDto;
import com.example.Banking_System.Service.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountServiceImpl accountServiceImpl;

    public AccountController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountServiceImpl.findAccountById(id));
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transferMoney(@RequestBody TransactionRequestDto request) {
        accountServiceImpl.transfer(request.getFromAccount(), request.getToAccount(), request.getAmount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> depositMoney(@RequestBody TransactionAmountRequestDto request) {
        accountServiceImpl.deposit(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Void> withdrawMoney(@RequestBody TransactionAmountRequestDto request) {
        accountServiceImpl.withdraw(request);
        return ResponseEntity.ok().build();
    }
}
