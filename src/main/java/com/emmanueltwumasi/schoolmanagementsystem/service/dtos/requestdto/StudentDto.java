package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto;

import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto.StudentCommon;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentDto extends StudentCommon {
    @NotEmpty(message = "password is required.")
    private String password;

}
