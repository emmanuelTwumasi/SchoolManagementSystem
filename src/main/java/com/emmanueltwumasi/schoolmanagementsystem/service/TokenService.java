package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;

public interface TokenService {

    /**
     * Generates the authorization token
     *
     * @param user The authenticated user
     * @return A string containing the authorization token
     */
    String generateToken(Student user);

    /**
     * Gets the jwt subject
     *
     * @param token The json web token on request header
     * @return A string containing the subject from the decoded jwt
     */
    String getTokenSubject(String token);

}