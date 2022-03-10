package com.pismo.transactions.controller;

import com.pismo.transactions.model.Account;
import com.pismo.transactions.model.AccountModel;
import com.pismo.transactions.model.Transaction;
import com.pismo.transactions.model.TransactionModel;
import com.pismo.transactions.repository.AccountRepository;
import com.pismo.transactions.repository.TransactionRepository;
import com.pismo.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionService transactionService;

    @PostMapping("")
    public ResponseEntity<Transaction> createTutorial(@Valid @RequestBody TransactionModel model) {
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
