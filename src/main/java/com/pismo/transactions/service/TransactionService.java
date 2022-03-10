package com.pismo.transactions.service;

import com.pismo.transactions.model.OperationType;
import com.pismo.transactions.model.Transaction;
import com.pismo.transactions.repository.AccountRepository;
import com.pismo.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction create(Transaction transaction){
        if(!accountRepository.existsById(transaction.getAccount().getId()))
            throw new RuntimeException("This account not exists.");

        if(transaction.getOperationType() == null)
            throw new RuntimeException("This Operation Type not exists.");

        return transactionRepository.save(transaction);
    }
}
