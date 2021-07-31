package com.blake.yu.service;

import com.blake.yu.model.dto.AccountDto;
import com.blake.yu.model.request.CreateAccountRequest;

public interface IAccountService {
    AccountDto createAccount(CreateAccountRequest request);
}
