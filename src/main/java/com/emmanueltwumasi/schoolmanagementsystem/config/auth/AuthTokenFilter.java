package com.emmanueltwumasi.schoolmanagementsystem.config.auth;


import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.util.stream.Stream;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final String[] excluded_urls = new String[]{
            "/api-docs",
            "/api/auth",
            "/schoolmanagementsystem.html" ,
            "/swagger-ui"
    };

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserDetailsService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if(shouldNotFilter(request))
        {
            filterChain.doFilter(request,response);
            return;
        }
        System.out.println(authorizationHeader);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
            throw new AuthenticationException("Authorization token is null or invalid");
        }

        String token = authorizationHeader.replace("Bearer ", "").trim();

        String tokenSubject = tokenService.getTokenSubject(token);

        Student authenticatedUser = (Student) userService.loadUserByUsername(tokenSubject);

        Authentication auth = new UsernamePasswordAuthenticationToken(authenticatedUser.getUsername(),authenticatedUser.getPassword(), authenticatedUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String url = request.getRequestURI();
        System.err.println(url);
        return Stream.of(excluded_urls).anyMatch(url::startsWith);
    }

}
