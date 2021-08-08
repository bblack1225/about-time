package com.blake.yu.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.blake.yu.security.token.JwtAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private static final String JWT_TOKEN_PREFIX = "Bearer ";
    private static final String SECRET_KEY = "Yu0203BYLaOoeUve1225";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null) {
            String jwtToken = authorizationHeader.substring(JWT_TOKEN_PREFIX.length());
            Authentication authentication = new JwtAuthenticationToken(null, jwtToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if(request.getServletPath().equals("/login")){
//            filterChain.doFilter(request,response);
//        } else {
//            String authorizationHeader = request.getHeader(AUTHORIZATION);
//            if(authorizationHeader != null && authorizationHeader.startsWith(JWT_TOKEN_PREFIX)){
//                try {
//                    String token = authorizationHeader.substring(JWT_TOKEN_PREFIX.length());
//                    Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
//                    JWTVerifier verifier = JWT.require(algorithm).build();
//                    DecodedJWT decodedJWT = verifier.verify(token);
//                    String username = decodedJWT.getSubject();
////                    String[] roles = decodedJWT.getClaim()
//                    UsernamePasswordAuthenticationToken authenticationToken =
//                            new UsernamePasswordAuthenticationToken(username, null, null);
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    filterChain.doFilter(request,response);
//                }catch (Exception e){
//
//                }
//            } else {
//                filterChain.doFilter(request,response);
//            }
//        }
//    }
}
