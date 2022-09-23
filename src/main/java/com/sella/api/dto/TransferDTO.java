package com.sella.api.dto;

import lombok.Data;

@Data
public class TransferDTO {

    private CreditorDTO creditor;
    private String accountId;
    private String receiverName;
    private String description;
    private Double amount;
    private String currency;
    private String executionDate;
}
