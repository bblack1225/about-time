package com.blake.yu.model.response;

import com.blake.yu.model.entity.Account;
import com.blake.yu.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AccountLoginResponse {

    private int id;

    private String name;

    private String email;

    private byte gender;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("invite_code")
    private String inviteCode;

//    @JsonProperty("couple_id")
//    private int coupleId;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    public AccountLoginResponse(Account account){
        this.id = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.gender = account.getGender();
        String birthDateStr = DateUtils.format(account.getBirthDate());
        this.birthDate = birthDateStr;
        this.inviteCode = account.getInviteCode();
//        this.coupleId = account.getCouple().getId();
    }
}
