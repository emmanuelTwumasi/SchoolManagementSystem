package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto;

import lombok.Data;

import java.util.List;

@Data
public class StudentData extends StudentCommon{
    private String username;
    private List<String> courses;

}

