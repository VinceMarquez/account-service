package com.mqz.service.impl;

import com.mqz.entity.Account;
import com.mqz.record.AccountRequest;
import com.mqz.repository.AccountRepository;
import com.mqz.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public Optional<Account> getAccountByAccountId(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(AccountRequest accountRequest) {
        Account account = Account.builder()
                .name(accountRequest.name())
                .birthDate(accountRequest.birthDate())
                .build();
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, AccountRequest accountRequest) {
        Account account = Account.builder()
                .id(id)
                .name(accountRequest.name())
                .birthDate(accountRequest.birthDate())
                .build();
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}
