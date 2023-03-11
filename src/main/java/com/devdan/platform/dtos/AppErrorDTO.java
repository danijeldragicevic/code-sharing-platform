package com.devdan.platform.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppErrorDTO {
    private String time;
    private int status;
    private String error;
    private String message;
    private String path;
}
