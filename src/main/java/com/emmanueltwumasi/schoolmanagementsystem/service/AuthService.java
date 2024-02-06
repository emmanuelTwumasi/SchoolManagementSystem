package com.emmanueltwumasi.schoolmanagementsystem.service;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentLogin;
import org.springframework.security.core.Authentication;

public interface AuthService {

    /**
     * Performs the user login
     *
     * @param userDTO Data transfer object containing user credentials for authentication operations
     * @return A full authentication object including the credentials
     */
    Authentication login(StudentLogin userDTO);

    /**
     * Performs the user registration
     *
     * @param userDTO Data transfer object containing user credentials for authentication operations
     * @return A user object including the credentials
     */
    Student register(StudentDto userDTO);

}
