package com.sella.api.dto;

import lombok.Data;

@Data
public class FabrickErrorDTO {

    private String code;
    private String description;
    private String params;
}
