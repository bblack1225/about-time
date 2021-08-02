package com.blake.yu.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountRequest {

    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @JsonProperty("email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "Password is mandatory")
    private String password;

    @JsonProperty("gender")
    @NotNull(message = "Gender is mandatory")
    private byte gender;

    @JsonProperty("birth_date")
    @NotBlank(message = "Birth date is mandatory")
    private String birthDate;
}
