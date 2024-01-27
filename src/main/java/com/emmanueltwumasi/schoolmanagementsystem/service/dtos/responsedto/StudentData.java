package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class StudentData {
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastname;

    @Column(name = "username")
    private String username;

    private List<String> courses;

}
