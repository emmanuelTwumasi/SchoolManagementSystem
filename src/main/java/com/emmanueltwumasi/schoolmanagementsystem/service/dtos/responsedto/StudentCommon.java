package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentCommon{
    private Long studentId;
    @NotEmpty(message = "firstname is required.")
    private String firstName;

    @NotEmpty(message = "lastname is required.")
    private String lastName;
}
