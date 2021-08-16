package com.blake.yu.security.model;

import java.util.List;

public class AuthenticationDetails {
    private List<String> roleNames;
    private String identityName;

    public AuthenticationDetails() {}

    public AuthenticationDetails(String identityName, List<String> roleNames) {
        this.identityName = identityName;
        this.roleNames = roleNames;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
