package com.sella.api.dto;

import lombok.Data;

@Data
public class TransactionsRequestDTO {

    private String accountId;
    private String fromDate;
    private String toDate;
}
