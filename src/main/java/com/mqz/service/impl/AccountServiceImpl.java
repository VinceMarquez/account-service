package com.mqz.service.impl;

import com.mqz.dto.request.UpdateAccountRequest;
import com.mqz.entity.Account;
import com.mqz.dto.request.CreateAccountRequest;
import com.mqz.exception.AccountNotFoundException;
import com.mqz.repository.AccountRepository;
import com.mqz.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    public static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    public Account getAccountByAccountId(Long id) {
        logger.info("Getting Account ID: {} from DB", id);
        Optional<Account> account = accountRepository.findById(id);
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    public Account createAccount(CreateAccountRequest accountRequest) {
        logger.info("Saving Account Name: {} to DB", accountRequest.name());
        Account account = Account.builder()
                .name(accountRequest.name())
                .birthDate(accountRequest.birthDate())
                .build();
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, UpdateAccountRequest accountRequest) {
        Account existingAccount = getAccountByAccountId(id);
        logger.info("Updating Account ID: {} to DB", id);
        existingAccount.setName(accountRequest.name());
        existingAccount.setBirthDate(accountRequest.birthDate());
        return accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        logger.info("Deleting Account ID: {} in DB", id);
        accountRepository.deleteById(id);
    }

}
