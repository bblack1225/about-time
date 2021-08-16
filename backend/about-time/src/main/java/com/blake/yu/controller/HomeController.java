package com.blake.yu.controller;

import com.blake.yu.util.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String getRandom(){
        return RandomUtils.inviteCode();
    }
}
