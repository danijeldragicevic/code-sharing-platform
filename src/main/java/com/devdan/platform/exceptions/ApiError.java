package com.devdan.platform.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiError {
    private String time;
    private int status;
    private String error;
    private String message;
    private String path;
}
