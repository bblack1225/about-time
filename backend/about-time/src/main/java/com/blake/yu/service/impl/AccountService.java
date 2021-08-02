package com.blake.yu.service.impl;

import com.blake.yu.dao.repository.IAccountRepository;
import com.blake.yu.exception.CreateAccountException;
import com.blake.yu.model.entity.Account;
import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.model.response.CreateAccountResponse;
import com.blake.yu.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService, UserDetailsService {

    private final IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findByEmail(username);
        if(optionalAccount.isEmpty()){
            throw new UsernameNotFoundException("User not found in db.");
        }

        Account account = optionalAccount.get();

        return new User(
                account.getEmail(),
                account.getPassword(),
                null);
    }

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {

        Optional<Account> optionalAccount = accountRepository.findByEmail(request.getEmail());

        if(optionalAccount.isPresent()){
            throw new CreateAccountException("User email already exist");
        }

        Account account = new Account(request);
        accountRepository.save(account);
        return new CreateAccountResponse(account);
    }
}
