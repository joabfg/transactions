package com.sistemas.transactions.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {

    @Test
    void dataModelToTransactionTypePagamento(){
        TransactionForm form = new TransactionForm(
                1l,
                OperationType.PAGAMENTO.getOperationTypeId(),
                2.0);
        Transaction transaction = form.toTransaction();

        assertThat(transaction.getAmount() > 0).isTrue();
        assertThat(transaction.getAccount().getId()).isEqualTo(form.getAccountId());
    }
    @Test
    void dataModelToTransactionTypeSaque(){
        TransactionForm form = new TransactionForm(
                1l,
                OperationType.SAQUE.getOperationTypeId(),
                2.0);
        Transaction transaction = form.toTransaction();

        assertThat(transaction.getAmount() > 0).isFalse();
        assertThat(transaction.getAccount().getId()).isEqualTo(form.getAccountId());
    }

}
