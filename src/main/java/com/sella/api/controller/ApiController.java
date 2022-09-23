package com.sella.api.controller;

import com.sella.api.dto.GenericResponseDTO;
import com.sella.api.dto.TransactionsRequestDTO;
import com.sella.api.dto.TransferDTO;
import com.sella.api.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
@Slf4j
public class ApiController {

    private ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/getTransactions")
    public ResponseEntity<GenericResponseDTO> getTransactions(@RequestBody TransactionsRequestDTO dto) {
        log.info("Rest call to get transactions with values: {}", dto);
        GenericResponseDTO response = new GenericResponseDTO();
        try {
            response.setFabrikResponse(apiService.getTransactions(dto));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatus("KO");
            response.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/getAmount/{accountId}")
    public ResponseEntity<GenericResponseDTO> getAmount(@PathVariable("accountId") String accountId) {
        log.debug("Rest call to get account amount for {}", accountId);
        GenericResponseDTO response = new GenericResponseDTO();
        try{
            response.setFabrikResponse(apiService.getAmount(accountId));
            return ResponseEntity.ok(response) ;
        } catch (Exception e) {
            response.setStatus("KO");
            response.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/doTransfer")
    public ResponseEntity<GenericResponseDTO> doTransfer(@RequestBody TransferDTO dto) {
        log.info("Rest call to do a transfer with values: {}", dto);
        GenericResponseDTO response = new GenericResponseDTO();
        try {
            response.setFabrikResponse(apiService.doTransfer(dto));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatus("KO");
            response.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}