package com.emmanueltwumasi.schoolmanagementsystem.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APiResponse<T> {

    private String message;
    private Boolean status;
    private int code;
    private T data;

}
