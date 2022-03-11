package com.pismo.transactions.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUnitTest {

    @Test
    void dataModelToTransactionTypePagamento(){
        TransactionModel model = new TransactionModel(
                1l,
                OperationType.PAGAMENTO.getOperationTypeId(),
                2.0);
        Transaction transaction = model.toTransaction();

        assertThat(transaction.getAmount() > 0).isTrue();
        assertThat(transaction.getAccount().getId()).isEqualTo(model.getAccountId());
    }
    @Test
    void dataModelToTransactionTypeSaque(){
        TransactionModel model = new TransactionModel(
                1l,
                OperationType.SAQUE.getOperationTypeId(),
                2.0);
        Transaction transaction = model.toTransaction();

        assertThat(transaction.getAmount() > 0).isFalse();
        assertThat(transaction.getAccount().getId()).isEqualTo(model.getAccountId());
    }

}
