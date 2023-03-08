package com.devdan.platform.utils;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@NoArgsConstructor
public class Util {
    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
    
    public static String formatDateTime(LocalDateTime time) {
        return time.format(PATTERN);
    }
    
    public static String getNewUUID() {
        return UUID.randomUUID().toString();
    }
}
