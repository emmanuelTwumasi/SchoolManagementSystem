package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto;

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

}
