package com.bankingSystem.BankingSystem.TransactionManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> findTransactionByAccountId(Long accountId);

    Optional<Transaction> findTransactionById(Long id);
}
