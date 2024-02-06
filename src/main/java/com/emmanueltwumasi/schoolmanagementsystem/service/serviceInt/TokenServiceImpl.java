package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    /**
     * Generates the authorization token
     *
     * @param user The authenticated user
     * @return A string containing the authorization token
     */
    @Override
    public String generateToken(Student user) {

        return JWT.create().withIssuer("School-Management-API")
                .withSubject(user.getUsername())
                .withClaim("id", user.getStudentId())
                .withExpiresAt(_getExpirationDate())
                .sign(getAlgorithm());
    }

    /**
     * Gets the jwt subject
     *
     * @param token The json web token on request header
     * @return A string containing the subject from the decoded jwt
     */
    @Override
    public String getTokenSubject(String token) {
        DecodedJWT decodedJWT = JWT.require(getAlgorithm())
                .withIssuer("School-Management-API")
                .build()
                .verify(token);
        return decodedJWT.getSubject();
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

    private Instant _getExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}