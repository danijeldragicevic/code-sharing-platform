package com.devdan.platform.exceptions;

import com.devdan.platform.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    private final Util util;
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        return new ResponseEntity<>(badRequestResponse(ex, request), HttpStatus.BAD_REQUEST);
    }
    
    private ApiError badRequestResponse(MethodArgumentNotValidException ex, WebRequest request) {
        ApiError error = new ApiError();
        error.setTime(util.formatDateTime(util.getCurrentDateTime()));
        error.setStatus(400);
        error.setError("Bad Request");
        error.setMessage(ex.getFieldError().getDefaultMessage());
        error.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
     
        return error;
    }
}
