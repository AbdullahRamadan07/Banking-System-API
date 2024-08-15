package com.example.Banking_System.Service;

import com.example.Banking_System.DTOs.AccountDto;
import com.example.Banking_System.DTOs.TransactionAmountRequestDto;
import com.example.Banking_System.Entities.Account;
import com.example.Banking_System.Repositories.AccountRepository;
import com.example.Banking_System.Security.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto findAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Account not found"));
        return new AccountDto(account.getId(), account.getAccountNumber(), account.getBalance(), account.getUser().getId());
    }

    @Transactional
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account sourceAccount = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> new UserNotFoundException("Source account not found"));
        Account destinationAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new UserNotFoundException("Destination account not found"));

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new UserNotFoundException("Insufficient funds");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);
    }

    @Transactional
    public void deposit(TransactionAmountRequestDto request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new UserNotFoundException("Account not found"));

        account.setBalance(account.getBalance().add(request.getAmount()));

        accountRepository.save(account);
    }

    @Transactional
    public void withdraw(TransactionAmountRequestDto request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new UserNotFoundException("Account not found"));

        if (account.getBalance().compareTo(request.getAmount()) < 0) {
            throw new UserNotFoundException("Insufficient funds");
        }

        account.setBalance(account.getBalance().subtract(request.getAmount()));

        accountRepository.save(account);
    }
}
