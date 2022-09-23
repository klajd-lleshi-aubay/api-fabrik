package com.sella.api;

import com.sella.api.dto.AccountDTO;
import com.sella.api.dto.CreditorDTO;
import com.sella.api.dto.TransactionsRequestDTO;
import com.sella.api.dto.TransferDTO;
import com.sella.api.service.ApiService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

	@Autowired
	private ApiService apiService;

	@Test
	void getTransactions() {
		TransactionsRequestDTO mockRequest = new TransactionsRequestDTO();
		mockRequest.setAccountId("14537780");
		mockRequest.setFromDate("2019-01-01");
		mockRequest.setToDate("2019-12-01");
		apiService.getTransactions(mockRequest);
	}

	@Test
	void getAmount() {
		String accountId = "14537780";
		apiService.getAmount(accountId);
	}

	@Test
	void doTransfer() {
		TransferDTO mockTransferDto = new TransferDTO();
		CreditorDTO creditorDTO = new CreditorDTO();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountCode("14537780");
		creditorDTO.setAccount(accountDTO);
		creditorDTO.setName("John Doe");
		mockTransferDto.setCreditor(creditorDTO);
		mockTransferDto.setAccountId("14537780");
		mockTransferDto.setReceiverName("Tony Foe");
		mockTransferDto.setReceiverName("Test");
		mockTransferDto.setCurrency("EUR");
		mockTransferDto.setAmount(56.78);
		mockTransferDto.setExecutionDate("2022-09-21");
		apiService.doTransfer(mockTransferDto);
	}

}
