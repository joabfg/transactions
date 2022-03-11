package com.sistemas.transactions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Account account;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    private Double amount;

    private LocalDateTime eventDate;

    public Transaction(Account account, OperationType operationType, Double amount, LocalDateTime eventDate) {
       boolean isPositiveOperation = operationType != null && operationType.isPositiveOperation();
        this.account = account;
        this.operationType = operationType;
        this.amount = amount * (isPositiveOperation ? 1:-1);
        this.eventDate = eventDate;
    }
}
