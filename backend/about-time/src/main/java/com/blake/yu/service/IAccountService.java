package com.blake.yu.service;

import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.model.response.CreateAccountResponse;

public interface IAccountService {
    CreateAccountResponse createAccount(CreateAccountRequest request);
}
