package com.sella.api.dto;

import lombok.Data;

@Data
public class FabrikTransactionResponseDTO extends FabrikResponseDTO {

    private ListTransactionDTO payload;
}
