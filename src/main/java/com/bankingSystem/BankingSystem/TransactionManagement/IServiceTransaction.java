package com.bankingSystem.BankingSystem.TransactionManagement;

import java.util.List;
import java.util.Optional;

public interface IServiceTransaction {
    Transaction save(Transaction transaction);
    Optional<List<Transaction>> getTransactionByAccountId(Long accountId);
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Long id);
}
