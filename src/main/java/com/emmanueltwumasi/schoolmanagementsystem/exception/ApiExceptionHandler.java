package com.emmanueltwumasi.schoolmanagementsystem.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleStudentNotFoundException(StudentNotFoundException ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(),FALSE,HttpStatus.NOT_FOUND.value(),null,request.getContextPath());
    }
    @ExceptionHandler(value = CourseNotFoundException.class)
    public ErrorResponse handleCourseNotFoundException(CourseNotFoundException ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(),FALSE,HttpStatus.NOT_FOUND.value(),null,request.getContextPath());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
       return errors;
    }
    @ExceptionHandler(value = CourseRegistrationException.class)
    public ErrorResponse handleCourseRegistrationException(CourseRegistrationException ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(), FALSE,HttpStatus.NOT_FOUND.value(),null,request.getContextPath());
    }
    @ExceptionHandler(value = CourseRegAlreadyExistException.class)
    public ErrorResponse handleCourseRegAlreadyExistException(CourseRegAlreadyExistException ex,HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(), FALSE,HttpStatus.CONFLICT.value(),null,request.getContextPath());
    }
    @ExceptionHandler(value = AccessDeniedException.class)
    public ErrorResponse handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(), FALSE,HttpStatus.FORBIDDEN.value(),null,request.getContextPath());
    }
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ErrorResponse handleUsernameNotFoundException(UsernameNotFoundException ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(), FALSE,HttpStatus.NOT_FOUND.value(),null,request.getContextPath());
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public ErrorResponse handleAuthenticationException(AuthenticationException ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(), FALSE,HttpStatus.UNAUTHORIZED.value(),null,request.getContextPath());
    }


    @ExceptionHandler(value = Exception.class)
    public ErrorResponse handleGeneralFoundException(Exception ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(), FALSE,HttpStatus.INTERNAL_SERVER_ERROR.value(),null,request.getContextPath());
    }

}
