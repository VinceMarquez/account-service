package com.mqz.service;

import com.mqz.entity.Account;
import com.mqz.record.AccountRequest;

import java.util.Optional;

public interface AccountService {

    Optional<Account> getAccountByAccountId(Long id);
    Account createAccount(AccountRequest accountRequest);
    Account updateAccount(Long id, AccountRequest accountRequest);
    void deleteAccount(Long id);

}
