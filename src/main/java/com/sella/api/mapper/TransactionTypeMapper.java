package com.sella.api.mapper;

import com.sella.api.dto.TransactionTypeDTO;
import com.sella.api.entity.TransactionType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionTypeMapper {

    public List<TransactionType> toEntity(List<TransactionTypeDTO> dtoList) {
        return dtoList.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
    }

    public TransactionType toEntity(TransactionTypeDTO dto) {
        TransactionType entity = new TransactionType();
        entity.setEnumeration(dto.getEnumeration());
        entity.setValue(dto.getValue());
        return entity;
    }
}
