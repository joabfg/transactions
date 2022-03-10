package com.pismo.transactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class AccountModel {

    @NotEmpty
    @JsonProperty(value = "document_number")
    private String documentNumber;

    public Account toAccount(){
        return new Account(null,documentNumber);
    }

}
