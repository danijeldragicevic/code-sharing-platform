package com.devdan.platform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppError {
    private String time;
    private int status;
    private String error;
    private String message;
    private String path;
}
