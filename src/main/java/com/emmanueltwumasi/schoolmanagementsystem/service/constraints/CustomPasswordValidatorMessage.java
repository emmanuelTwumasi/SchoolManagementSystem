package com.emmanueltwumasi.schoolmanagementsystem.service.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CustomPasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomPasswordValidatorMessage {

    String message() default "Password can not be blank and should be more than 6 letters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}