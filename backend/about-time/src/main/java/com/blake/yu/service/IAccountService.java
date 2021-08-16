package com.blake.yu.service;

import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.model.request.CreateGroupRequest;
import com.blake.yu.model.response.AccountLoginResponse;
import com.blake.yu.model.response.CreateAccountResponse;
import com.blake.yu.model.response.CreateGroupResponse;

public interface IAccountService {
    CreateAccountResponse createAccount(CreateAccountRequest request);

    AccountLoginResponse getLoginResponseByEmail(String email);

    CreateGroupResponse createGroup(CreateGroupRequest request);
}
