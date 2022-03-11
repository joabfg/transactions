package com.sistemas.transactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountForm {

    @NotEmpty
    @JsonProperty(value = "document_number")
    private String documentNumber;

    public Account toAccount(){
        return new Account(null,documentNumber);
    }

}
