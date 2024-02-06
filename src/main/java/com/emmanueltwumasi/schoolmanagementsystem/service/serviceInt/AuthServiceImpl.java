package com.emmanueltwumasi.schoolmanagementsystem.service.serviceInt;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Student;
import com.emmanueltwumasi.schoolmanagementsystem.service.AuthService;
import com.emmanueltwumasi.schoolmanagementsystem.service.StudentService;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto.StudentDto;
import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private StudentService userService;


    @Override
    public Authentication login(StudentLogin userDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.getUsername(),
                userDTO.getPassword());

        return manager.authenticate(token);
    }

    @Override
    public Student register(StudentDto userDTO) {
        return userService.addStudent(userDTO);
    }


}
