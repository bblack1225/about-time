package com.blake.yu.service.impl;

import com.blake.yu.model.dto.AccountDto;
import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Override
    public AccountDto createAccount(CreateAccountRequest request) {
        return null;
    }
}
