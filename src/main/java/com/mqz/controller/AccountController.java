package com.mqz.controller;

import com.mqz.dto.request.UpdateAccountRequest;
import com.mqz.entity.Account;
import com.mqz.dto.request.CreateAccountRequest;
import com.mqz.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AccountController {

    //TODO practice exception handling, streams, unit tests

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        logger.info("Received getAccount request for Account ID: {}", id);
        return ResponseEntity.ok(accountService.getAccountByAccountId(id));
    }

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody CreateAccountRequest account) {
        logger.info("Received createAccount request for Account Name: {}", account.name());
        logger.info("Request Body: {}", account);
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @PatchMapping("/account/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id,
                                                 @Valid @RequestBody UpdateAccountRequest account) {
        logger.info("Received updateAccount request for Account ID: {}", id);
        logger.info("Request Body: {}", account);
        return ResponseEntity.ok(accountService.updateAccount(id, account));
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        logger.info("Received deleteAccount request for Account ID: {}", id);
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
