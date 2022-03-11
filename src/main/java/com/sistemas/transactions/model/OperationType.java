package com.sistemas.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationType {

    COMPRA_A_VISTA(1,"COMPRA A VISTA"),
    COMPRA_PARCELADA(2,"compra parcelada"),
    SAQUE(3,"SAQUE"),
    PAGAMENTO(4,"PAGAMENTO");

    private long operationTypeId;
    private String description;

    public static OperationType getById(Long id) {
        for(OperationType e : values()) {
            if(e.operationTypeId == id) return e;
        }
        return null;
    }

    public  boolean isPositiveOperation(){
        return this.equals(OperationType.PAGAMENTO);
    }

}
