package com.sella.api.service;

import com.sella.api.client.FabrikClient;
import com.sella.api.dto.*;
import com.sella.api.entity.TransactionType;
import com.sella.api.mapper.TransactionMapper;
import com.sella.api.mapper.TransactionTypeMapper;
import com.sella.api.repository.TransactionRepository;
import com.sella.api.repository.TransactionTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ApiService {

    @Value("${feign.fabrik.header.auth-schema}")
    private String AUTH_SCHEMA_HEADER;

    @Value("${feign.fabrik.header.apikey}")
    private String APIKEY_HEADER;

    private FabrikClient fabrikClient;
    private TransactionRepository transactionRepository;
    private TransactionTypeRepository transactionTypeRepository;
    private TransactionMapper transactionMapper;
    private TransactionTypeMapper transactionTypeMapper;

    public ApiService(FabrikClient fabrikClient, TransactionRepository transactionRepository, TransactionTypeRepository transactionTypeRepository, TransactionMapper transactionMapper, TransactionTypeMapper transactionTypeMapper) {
        this.fabrikClient = fabrikClient;
        this.transactionRepository = transactionRepository;
        this.transactionTypeRepository = transactionTypeRepository;
        this.transactionMapper = transactionMapper;
        this.transactionTypeMapper = transactionTypeMapper;
    }

    public FabrikResponseDTO getTransactions(TransactionsRequestDTO dto) {
            FabrikTransactionResponseDTO fabrikResponse = fabrikClient.getTransactions(APIKEY_HEADER, AUTH_SCHEMA_HEADER, dto.getAccountId(), dto.getFromDate(), dto.getToDate());
            fabrikResponse.getPayload().getList().forEach(transactionDto -> {
                TransactionType transactionType = transactionTypeRepository.findByEnumerationAndValue(transactionDto.getType().getEnumeration(), transactionDto.getType().getValue());
                if(transactionType==null) {
                    transactionType = transactionTypeRepository.saveAndFlush(transactionTypeMapper.toEntity(transactionDto.getType()));
                }
                if(!transactionRepository.existsByTransactionId(transactionDto.getTransactionId())) {
                    transactionRepository.saveAndFlush(transactionMapper.toEntity(transactionDto, transactionType));
                }
            });
            return fabrikResponse;
    }

    public FabrikResponseDTO getAmount(String accountId) {
        return fabrikClient.getAmount(APIKEY_HEADER, AUTH_SCHEMA_HEADER, accountId);
    }

    public FabrikResponseDTO doTransfer(TransferDTO dto) {
        return fabrikClient.doTransfer(APIKEY_HEADER, AUTH_SCHEMA_HEADER, dto.getAccountId(), dto);
    }
}
