package com.devdan.platform.exceptions;

import com.devdan.platform.dtos.AppErrorDTO;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.models.AppError;
import com.devdan.platform.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class _DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    private final Util util;
    private final IModelMapper mapper;
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        AppErrorDTO appErrorDTO = mapper.mapToDto(badRequestResponse(ex, request));
        
        return new ResponseEntity<>(appErrorDTO, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(CodeSnippetDoesNotExists_APIException.class)
    public ResponseEntity<Object> handleCodeSnippetDoesNotExistsApiException(WebRequest request) {
        AppErrorDTO appErrorDTO = mapper.mapToDto(notFoundResponse(request));
        
        return new ResponseEntity<>(appErrorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CodeSnippetDoesNotExists_HtmlException.class)
    public String handleCodeSnippetDoesNotExistsHtmlException(WebRequest request, Model model) {
        AppErrorDTO appErrorDTO = mapper.mapToDto(notFoundResponse(request));
        model.addAttribute("appErrorDTO", appErrorDTO);

        return "codeSnippetDoesNotExists_Page";
    }
    
    private AppError badRequestResponse(MethodArgumentNotValidException ex, WebRequest request) {
        AppError appError = new AppError();
        appError.setTime(util.formatDateTime(util.getCurrentDateTime()));
        appError.setStatus(400);
        appError.setError("Bad Request");
        appError.setMessage(ex.getFieldError().getDefaultMessage());
        appError.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
     
        return appError;
    }
    
    private AppError notFoundResponse(WebRequest request) {
        AppError appError = new AppError();
        appError.setTime(util.formatDateTime(util.getCurrentDateTime()));
        appError.setStatus(404);
        appError.setError("Not Found");
        appError.setMessage("Code snippet with requested id does not exists!");
        appError.setPath(((ServletWebRequest)request).getRequest().getRequestURI());

        return appError;
    }
}
