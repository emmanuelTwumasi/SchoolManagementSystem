package com.emmanueltwumasi.schoolmanagementsystem.service.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
