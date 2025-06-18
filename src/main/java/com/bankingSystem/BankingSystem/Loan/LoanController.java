package com.bankingSystem.BankingSystem.Loan;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceLoan.save(loan));
    }

    @GetMapping("/user/{UserId}")
    public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable Long userId){
        return serviceLoan.getLoansByUserId(userId)
                .map(loan -> ResponseEntity.ok(loan))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans(){
        return ResponseEntity.ok(serviceLoan.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanBYId(@PathVariable Long id){
        return serviceLoan.getLoanById(id)
                .map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoanStatus(@PathVariable Long id, @RequestBody String status){
        return ResponseEntity.ok(serviceLoan.updateLoanStatus(id, status));
    }
}