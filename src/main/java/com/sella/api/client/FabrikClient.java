package com.sella.api.client;

import com.sella.api.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "fabrikCLient", url = "${feign.fabrik.url.base}")
public interface FabrikClient {

    @RequestMapping(method = RequestMethod.GET, value = "${feign.fabrik.url.get.transactions}", produces = "application/json", consumes = "application/json")
    FabrikTransactionResponseDTO getTransactions(@RequestHeader("apikey") String apikey, @RequestHeader("Auth-Schema") String authSchema, @PathVariable("accountId") String accountId, @RequestParam("fromAccountingDate") String fromDate, @RequestParam("toAccountingDate") String toDate);

    @RequestMapping(method = RequestMethod.GET, value = "${feign.fabrik.url.get.amount}", produces = "application/json", consumes = "application/json")
    FabrikResponseDTO getAmount(@RequestHeader("apikey") String apikey, @RequestHeader("Auth-Schema") String authSchema, @PathVariable("accountId") String accountId);

    @RequestMapping(method = RequestMethod.POST, value = "${feign.fabrik.url.post.transfer}", produces = "application/json", consumes = "application/json")
    FabrikResponseDTO doTransfer(@RequestHeader("apikey") String apikey, @RequestHeader("Auth-Schema") String authSchema, @PathVariable("accountId") String accountId, TransferDTO dto);
}
