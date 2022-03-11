package com.sistemas.transactions.controller;

import com.sistemas.transactions.model.Account;
import com.sistemas.transactions.model.AccountForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void createNewAccountTest() {
        String document = "02547896547";
        AccountForm form = new AccountForm(document);


        HttpEntity<AccountForm> httpEntity = new HttpEntity<>(form);

        ResponseEntity<Account> response = this.testRestTemplate
                .exchange("/accounts", HttpMethod.POST, httpEntity, Account.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getDocumentNumber(), "02547896547");
    }

    @Test
    public void createNewAccountWithErrorTest() {
        AccountForm form = new AccountForm("");


        HttpEntity<AccountForm> httpEntity = new HttpEntity<>(form);

        ResponseEntity<Account> response = this.testRestTemplate
                .exchange("/accounts", HttpMethod.POST, httpEntity, Account.class);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}
