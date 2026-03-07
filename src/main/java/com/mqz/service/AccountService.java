package com.mqz.service;

import com.mqz.dto.request.UpdateAccountRequest;
import com.mqz.entity.Account;
import com.mqz.dto.request.CreateAccountRequest;

public interface AccountService {

    Account getAccountByAccountId(Long id);
    Account createAccount(CreateAccountRequest accountRequest);
    Account updateAccount(Long id, UpdateAccountRequest accountRequest);
    void deleteAccount(Long id);

}
