package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class StudentData extends StudentCommon{
    @Column(name = "username")
    private String username;

    private List<String> courses;

}
