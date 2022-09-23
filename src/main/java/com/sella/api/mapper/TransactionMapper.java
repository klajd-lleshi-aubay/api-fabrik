package com.sella.api.mapper;

import com.sella.api.dto.TransactionDTO;
import com.sella.api.entity.Transaction;
import com.sella.api.entity.TransactionType;
import com.sella.api.enumeration.Currency;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    public List<Transaction> toEntity(List<TransactionDTO> dtoList) {
        return dtoList.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
    }

    public Transaction toEntity(TransactionDTO dto) {
        Transaction entity = new Transaction();
        entity.setTransactionId(dto.getTransactionId());
        entity.setOperationId(dto.getOperationId());
        entity.setAccountingDate(dto.getAccountingDate());
        entity.setValueDate(dto.getValueDate());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(Currency.valueOf(dto.getCurrency()));
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public Transaction toEntity(TransactionDTO dto, TransactionType transactionType) {
        Transaction entity = new Transaction();
        entity.setTransactionId(dto.getTransactionId());
        entity.setOperationId(dto.getOperationId());
        entity.setAccountingDate(dto.getAccountingDate());
        entity.setValueDate(dto.getValueDate());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(Currency.valueOf(dto.getCurrency()));
        entity.setDescription(dto.getDescription());
        entity.setType(transactionType);
        return entity;
    }
}
