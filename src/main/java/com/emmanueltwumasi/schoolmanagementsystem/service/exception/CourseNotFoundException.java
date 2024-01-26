package com.emmanueltwumasi.schoolmanagementsystem.service.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String s) {
        super(s);
    }
}
