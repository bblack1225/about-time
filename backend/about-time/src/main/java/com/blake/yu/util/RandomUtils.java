package com.blake.yu.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    private static final int INVITE_CODE_LENGTH = 10;

    public static String inviteCode(){
        String code = RandomStringUtils.randomAlphanumeric(INVITE_CODE_LENGTH).toUpperCase();
        return code;
    }
}
