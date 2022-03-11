package com.sistemas.transactions.service;

import com.sistemas.transactions.model.Transaction;
import com.sistemas.transactions.repository.AccountRepository;
import com.sistemas.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
