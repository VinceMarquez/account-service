package com.mqz.controller;

import com.mqz.entity.Account;
import com.mqz.record.AccountRequest;
import com.mqz.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
public class AccountController {

    //TODO practice exception handling, streams, unit tests

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        logger.info("Received getAccount request for Account ID: {}", id);
        return ResponseEntity.ok(accountService.getAccountByAccountId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found")));
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountRequest account) {
        logger.info("Received createAccount request for Account Name: {}", account.name());
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @PatchMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id,
                                                 @Valid @RequestBody AccountRequest account) {
        logger.info("Received updateAccount request for Account ID: {}", id);
        return ResponseEntity.ok(accountService.updateAccount(id, account));
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        logger.info("Received deleteAccount request for Account ID: {}", id);
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
