package com.sella.api.dto;

import lombok.Data;

@Data
public class GenericResponseDTO {

    private String status;
    private String message;
    private FabrikResponseDTO fabrikResponse;
}
