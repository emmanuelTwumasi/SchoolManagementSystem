package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.responsedto;

import com.emmanueltwumasi.schoolmanagementsystem.service.constraints.CustomPasswordValidatorMessage;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentLogin {
    @NotNull
    private String username;
    @CustomPasswordValidatorMessage
    private String password;

}
