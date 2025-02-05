package com.bankingSystem.BankingSystem.Loan;

import com.bankingSystem.BankingSystem.TransactionManagement.IServiceTransaction;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    private IServiceLoan serviceLoan;

    @PostMapping("/create")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        return new ResponseEntity<>(serviceLoan.save(loan), HttpStatus.CREATED);
    }

    @GetMapping("/user/{UserId}")
    public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable Long userId){
        return serviceLoan.getLoansByUserId(userId)
                .map(loan -> new ResponseEntity<>(loan, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans(){
        return new ResponseEntity<>(serviceLoan.getAllLoans(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanBYId(@PathVariable Long id){
        return serviceLoan.getLoanById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoanStatus(@PathVariable Long id, @RequestBody String status){
        return new ResponseEntity<>(serviceLoan.updateLoanStatus(id, status), HttpStatus.OK);
    }
}


