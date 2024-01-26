package com.emmanueltwumasi.schoolmanagementsystem.service.requestdto;

import com.emmanueltwumasi.schoolmanagementsystem.entity.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentDto {
    @Column(name = "firstName")
    @NotEmpty(message = "firstname is required.")
    private String firstName;

    @Column(name = "lastName")
    @NotEmpty(message = "lastname is required.")
    private String lastname;

    @Column(name = "password")
    @NotEmpty(message = "password is required.")
    private String password;

    @Column(name="role")
    @NotEmpty(message = "role is required.")
    private Role role;
}
