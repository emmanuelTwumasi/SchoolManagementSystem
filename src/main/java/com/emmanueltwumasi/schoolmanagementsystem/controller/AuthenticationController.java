package com.emmanueltwumasi.schoolmanagementsystem.controller;

import com.emmanueltwumasi.schoolmanagementsystem.service.AuthService;
import com.emmanueltwumasi.schoolmanagementsystem.service.TokenService;
import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.APiResponse;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    /**
     * Performs the user login
     *
     * @param userDTO A data transfer object containing the user data to perform the login
     *
     * @return The authorization token if successful, or an unauthorized status if there is an error.
     */
    @PostMapping(value = "/login")
    public ResponseEntity<APiResponse<String>> login(@RequestBody @Valid StudentLogin userDTO) {

        Authentication auth = authService.login(userDTO);

        Student authenticatedUser = (Student) auth.getPrincipal();

        String token = tokenService.generateToken(authenticatedUser);

        return ResponseEntity.ok(new APiResponse<>("Login successful", true, OK.value(), token));
    }

    /**
     * Performs the user registration
     *
     * @param userDTO A data transfer object containing the user data to perform the registration
     *
     * @return The registered user if successful, or null if there is an error.
     */

    @PostMapping(value = "/register")
    public ResponseEntity<APiResponse<Student>> register(@RequestBody @Valid StudentDto userDTO) {

        Student user = authService.register(userDTO);

        return ResponseEntity.ok(new APiResponse<>("Data saved successfully", true, CREATED.value(), user));
    }

}
