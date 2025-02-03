package com.bankingSystem.BankingSystem.TransactionManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements IServiceTransaction{
    @Autowired
    private TransactionRepository repositoryTransaction;

    @Override
    public Transaction save(Transaction transaction) {
        return repositoryTransaction.save(transaction);
    }

    @Override
    public Optional<List<Transaction>> getTransactionByAccountId(Long accountId) {
        return repositoryTransaction.findTransactionByAccountId(accountId);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repositoryTransaction.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return repositoryTransaction.findTransactionById(id);
    }
}
