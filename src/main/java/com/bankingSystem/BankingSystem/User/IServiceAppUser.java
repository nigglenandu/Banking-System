package com.bankingSystem.BankingSystem.User;

import java.util.List;
import java.util.Optional;

public interface IServiceAppUser {
    AppUser save(AppUser appUser);
    Optional<AppUser> findUserByUsername(String username);
    List<AppUser> getAllUsers();
}
