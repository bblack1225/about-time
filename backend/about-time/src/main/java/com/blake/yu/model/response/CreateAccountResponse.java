package com.blake.yu.model.response;

import com.blake.yu.model.entity.Account;
import com.blake.yu.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("gender")
    private byte gender;

    @JsonProperty("birth_date")
    private String birthDate;

    public CreateAccountResponse(Account account) {
        String birthDateStr = DateUtils.format(account.getBirthDate());
        this.id = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.gender = account.getGender();
        this.birthDate = birthDateStr;
    }
}
