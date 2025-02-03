package com.bankingSystem.BankingSystem.AccountManagement;

import java.util.List;
import java.util.Optional;

public interface IServiceAccount {
    Account saveAccount(Account account);
    Optional<List<Account>> getAccountsByUserId(Long userId);
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long id);
    boolean deleteAccountById(Long id);
}
