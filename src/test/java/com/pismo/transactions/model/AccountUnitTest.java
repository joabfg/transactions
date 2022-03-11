package com.pismo.transactions.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountUnitTest {

    @Test
    void dataModelToAccount(){
        AccountModel model = new AccountModel("06904751478");
        Account account = model.toAccount();

        assertThat(account.getDocumentNumber()).isEqualTo(model.getDocumentNumber());
    }
}
