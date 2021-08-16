package com.blake.yu.service.impl;

import com.blake.yu.dao.repository.IAccountRepository;
import com.blake.yu.exception.AccountNotFoundException;
import com.blake.yu.exception.CreateAccountException;
import com.blake.yu.exception.InviteCodeNotFoundException;
import com.blake.yu.model.entity.Account;
import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.model.request.CreateGroupRequest;
import com.blake.yu.model.response.AccountLoginResponse;
import com.blake.yu.model.response.CreateAccountResponse;
import com.blake.yu.model.response.CreateGroupResponse;
import com.blake.yu.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService, UserDetailsService {

    private final IAccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findByEmail(username);
        if(optionalAccount.isEmpty()){
            throw new UsernameNotFoundException("User not found in db.");
        }

        Account account = optionalAccount.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));

        return new User(
                account.getEmail(),
                account.getPassword(),
                authorities);
    }

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {

        Optional<Account> optionalAccount = accountRepository.findByEmail(request.getEmail());

        if(optionalAccount.isPresent()){
            throw new CreateAccountException("User email already exist");
        }

        Account account = new Account(request);
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        account.setPassword(hashedPassword);
        account = accountRepository.save(account);
        return new CreateAccountResponse(account);
    }

    @Override
    public AccountLoginResponse getLoginResponseByEmail(String email) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(email);
        if(optionalAccount.isEmpty()){
            throw new AccountNotFoundException("User email is not exist");
        }
        Account account = optionalAccount.get();
        AccountLoginResponse test = new AccountLoginResponse(account);
        return test;
    }

    @Override
    public CreateGroupResponse createGroup(CreateGroupRequest request) {
        Optional<Account> optionalAccount = accountRepository.queryByInviteCodeAndStatus(request.getInviteCode());
        if(optionalAccount.isEmpty()){
            throw new InviteCodeNotFoundException("Invite Code is not exist or can not join the group");
        }

        return null;
    }
}
