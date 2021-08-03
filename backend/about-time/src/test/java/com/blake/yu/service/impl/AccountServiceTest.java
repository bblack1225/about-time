package com.blake.yu.service.impl;

import com.blake.yu.dao.repository.IAccountRepository;
import com.blake.yu.model.entity.Account;
import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.model.response.CreateAccountResponse;
import com.blake.yu.service.IAccountService;
import com.blake.yu.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private IAccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;


    @Test
    void createAccount() throws ParseException {
        String birthdateStr = "1996-12-25";
        Date birthdate = DateUtils.parse(birthdateStr,"yyyy-MM-dd");

        CreateAccountRequest createAccountRequest = CreateAccountRequest.builder()
                .name("Blake")
                .email("blake@gmail.com")
                .password("Do!ng123")
                .gender((byte)1)
                .birthDate(birthdateStr)
                .build();

        Account incomingAccount = new Account(createAccountRequest);

        Account actualAccount = Account.builder()
                .id(1)
                .name("Blake")
                .email("blake@gmail.com")
                .password("Do!ng123")
                .gender((byte)1)
                .birthDate(birthdate)
                .isEnable(true)
                .build();

        CreateAccountResponse expectedResponse =
                CreateAccountResponse.builder()
                        .id(1)
                        .name("Blake")
                        .email("blake@gmail.com")
                        .password("Do!ng123")
                        .gender((byte)1)
                        .birthDate(birthdateStr)
                        .build();

        when(accountRepository.save(Mockito.any(Account.class))).thenReturn(actualAccount);

        CreateAccountResponse actualResponse = accountService.createAccount(createAccountRequest);

        verify(accountRepository, times(1)).save(any());
        assertThat(actualResponse.getId()).isEqualTo(expectedResponse.getId());
    }
}