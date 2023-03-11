package com.devdan.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CodeSharingPlatformApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CodeSharingPlatformApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatformApplication.class, args);
    }
}
