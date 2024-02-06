package com.emmanueltwumasi.schoolmanagementsystem.exception;

import com.emmanueltwumasi.schoolmanagementsystem.service.dtos.APiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorResponse  extends APiResponse<String> {
private String path;

    public ErrorResponse(String message , Boolean status , int code , String data, String path) {
        super(message , status , code , data);
        this.path = path;
    }

}
