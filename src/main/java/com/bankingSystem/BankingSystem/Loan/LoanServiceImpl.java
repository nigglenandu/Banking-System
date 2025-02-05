package com.bankingSystem.BankingSystem.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements IServiceLoan{
    @Autowired
    private LoanRepository repositoryLoan;

    @Override
    public Loan save(Loan loan) {
        return repositoryLoan.save(loan);
    }

    @Override
    public Optional<List<Loan>> getLoansByUserId(Long userId) {
        return repositoryLoan.findByUserId(userId);
    }

    @Override
    public List<Loan> getAllLoans() {
        return repositoryLoan.findAll();
    }

    @Override
    public Optional<Loan> getLoanById(Long id) {
        return repositoryLoan.findById(id);
    }

    @Override
    public Loan updateLoanStatus(Long id, String status) {
        Optional<Loan> loanOpt = repositoryLoan.findById(id);
        if(loanOpt.isPresent()){
            Loan loan = loanOpt.get();
            loan.setLoanStatus(status);
            return repositoryLoan.save(loan);
        } else {
            return null;
        }
    }
}
