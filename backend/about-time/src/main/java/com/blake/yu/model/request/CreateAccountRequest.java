package com.blake.yu.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountRequest {

    private String name;

    private String email;

    private String password;

    private byte gender;

    @JsonProperty("birth_date")
    private String birthDate;
}
