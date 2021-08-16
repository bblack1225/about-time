package com.blake.yu.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateGroupRequest {

    @JsonProperty("invite_code")
    private String inviteCode;
}
