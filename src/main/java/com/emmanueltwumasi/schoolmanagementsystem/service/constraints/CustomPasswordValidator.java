package com.emmanueltwumasi.schoolmanagementsystem.service.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class CustomPasswordValidator implements ConstraintValidator<CustomPasswordValidatorMessage, String> {
    @Override
    public void initialize(CustomPasswordValidatorMessage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String msg, ConstraintValidatorContext constraintValidatorContext) {
        if(msg==null) return  false;
        if (msg.isEmpty()) return false;
        return msg.length() > 3;
    }
}
