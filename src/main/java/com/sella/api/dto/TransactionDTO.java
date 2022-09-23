package com.sella.api.dto;

import lombok.Data;

@Data
public class TransactionDTO {

    private String transactionId;
    private String operationId;
    private String accountingDate;
    private String valueDate;
    private TransactionTypeDTO type;
    private Double amount;
    private String currency;
    private String description;
}
