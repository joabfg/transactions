package com.pismo.transactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionModel {

    @JsonProperty(value = "account_id")
    private Long accountId;

    @Min(value = 0 ,message = "The operation_type_id value must be bettwen 0 and 4.")
    @Max(value = 4 ,message = "The operation_type_id value must be bettwen 0 and 4.")
    @JsonProperty(value = "operation_type_id")
    private Long operationTypeId;

    @Min(value = 0, message = "The amount value must be a positive number.")
    @JsonProperty(value = "amount")
    private Double amount;

    public Transaction toTransaction(){

        return new Transaction(
                new Account(this.accountId,"")
                ,OperationType.getById(this.operationTypeId)
                ,this.amount
                , LocalDateTime.now());
    }
}
