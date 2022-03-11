package com.sistemas.transactions.controller;

import com.sistemas.transactions.model.Transaction;
import com.sistemas.transactions.model.TransactionForm;
import com.sistemas.transactions.repository.TransactionRepository;
import com.sistemas.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionService transactionService;

    @PostMapping("")
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionForm model) {
        try {
            Transaction transaction = transactionService.create(model.toTransaction());
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
