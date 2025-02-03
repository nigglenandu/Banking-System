package com.bankingSystem.BankingSystem.AccountManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IServiceAccount{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<List<Account>> getAccountsByUserId(Long userId) {
        return accountRepository.findAccountByUserId(userId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public boolean deleteAccountById(Long id) {
        accountRepository.deleteById(id);
        return false;
    }
}
