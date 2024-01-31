package com.emmanueltwumasi.schoolmanagementsystem.service.dtos;

import lombok.Data;

@Data
public class APIResult<T> {

    private String message;
    private Boolean status;
    private int count;
    private T data;

}
