package com.blake.yu.security.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.blake.yu.model.response.AccountLoginResponse;
import com.blake.yu.service.IAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final IAccountService accountService;

    @Value("${about-time.jwt.secret-key}")
    private String secretKey;

    private static Integer ACCESS_TOKEN_EXPIRED_AFTER_MILLIS = 1000 * 60 * 10;

    private static Integer REFRESH_TOKEN_EXPIRED_AFTER_MILLIS = 1000 * 60 * 60 * 30;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());

        User user = (User)  authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());
        String accessToken = JWT
                .create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRED_AFTER_MILLIS))
                .withIssuer(request.getRequestURI())
                .sign(algorithm);
        String refreshToken = JWT
                .create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRED_AFTER_MILLIS))
                .withIssuer(request.getRequestURI())
                .sign(algorithm);

        AccountLoginResponse loginResponse = accountService.getLoginResponseByEmail(user.getUsername());
        loginResponse.setAccessToken(accessToken);
        loginResponse.setRefreshToken(refreshToken);

        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(loginResponse));
        out.flush();
        out.close();
    }
}
