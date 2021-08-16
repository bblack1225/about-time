package com.blake.yu.security.provider;

import com.blake.yu.exception.JwtAuthenticationException;
import com.blake.yu.security.token.JwtAuthenticationToken;
import com.blake.yu.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtUtil jwtUtil;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String jwtToken = ((JwtAuthenticationToken) authentication).getCredentials();
        Authentication validAuthentication;
        try {
            String username = jwtUtil.extractSubject(jwtToken);

            // todo: multiple role
            List<String> roleNames = Arrays.asList("USER");
            List<GrantedAuthority> authorities  = roleNames.stream()
                    .map(roleName -> new SimpleGrantedAuthority(roleName))
                    .collect(Collectors.toList());

            validAuthentication = new JwtAuthenticationToken(username, jwtToken, authorities);
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
