package com.emmanueltwumasi.schoolmanagementsystem.service.dtos.requestdto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnrollmentReq {
    @NotNull(message = "Course id is required.")
    private Long courseId;
}
