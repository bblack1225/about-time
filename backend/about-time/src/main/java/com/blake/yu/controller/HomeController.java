package com.blake.yu.controller;

import com.blake.yu.util.JwtUtil;
import com.blake.yu.util.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final JwtUtil jwtUtil;

    @GetMapping
    public String getRandom(){
        return RandomUtils.inviteCode();
    }
}
