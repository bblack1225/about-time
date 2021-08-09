package com.blake.yu.security.provider;

import com.blake.yu.exception.JwtAuthenticationException;
import com.blake.yu.security.token.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String jwtToken = ((JwtAuthenticationToken) authentication).getCredentials();
        Authentication validAuthentication;
        try {
            validAuthentication = new JwtAuthenticationToken(null, jwtToken);
        } catch (IllegalArgumentException e) {
            throw new JwtAuthenticationException(e.toString());
        } catch (Exception e){
            throw new JwtAuthenticationException(e.toString());
        }
        return validAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
