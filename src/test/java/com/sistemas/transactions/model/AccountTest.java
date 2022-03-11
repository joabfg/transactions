package com.sistemas.transactions.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void dataModelToAccount(){
        AccountForm form = new AccountForm("06904751478");
        Account account = form.toAccount();

        assertThat(account.getDocumentNumber()).isEqualTo(form.getDocumentNumber());
    }
}
