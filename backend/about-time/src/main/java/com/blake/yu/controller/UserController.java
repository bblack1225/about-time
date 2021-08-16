package com.blake.yu.controller;

import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.model.request.CreateGroupRequest;
import com.blake.yu.model.response.CreateAccountResponse;
import com.blake.yu.model.response.CreateGroupResponse;
import com.blake.yu.service.impl.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class UserController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest request){
        CreateAccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/join-group")
    public ResponseEntity<CreateGroupResponse> joinGroupViaInviteCode(@RequestBody CreateGroupRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.createGroup(request));
    }

}
