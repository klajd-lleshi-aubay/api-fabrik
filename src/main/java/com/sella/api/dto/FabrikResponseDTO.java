package com.sella.api.dto;

import lombok.Data;

@Data
public class FabrikResponseDTO {

    private String status;
    private FabrickErrorDTO[] error;
    private FabrickErrorDTO[] errors;
    private Object payload;
}
