package com.bankingSystem.BankingSystem.Loan;

import java.util.List;
import java.util.Optional;

public interface IServiceLoan {
    Loan save(Loan loan);
    Optional<List<Loan>> getLoansByUserId(Long userId);
    List<Loan> getAllLoans();
    Optional<Loan> getLoanById(Long id);
    Loan updateLoanStatus(Long id, String status);
}
