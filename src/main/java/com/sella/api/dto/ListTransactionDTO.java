package com.sella.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListTransactionDTO {

    private List<TransactionDTO> list;
}
