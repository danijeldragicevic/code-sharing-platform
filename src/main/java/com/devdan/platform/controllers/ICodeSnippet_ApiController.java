package com.devdan.platform.controllers;

import com.devdan.platform.dtos.CodeSnippetDTO;
import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_APIException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/api/code")
public interface ICodeSnippet_ApiController {
    @PostMapping(path = "/new")
    ResponseEntity<Map<String, String>> createCodeSnippet(@RequestBody @Valid CodeSnippetDTO codeSnippetDTO);
    
    @GetMapping("/{id}")
    ResponseEntity<CodeSnippetDTO> getCodeSnippetById(@PathVariable String id) throws CodeSnippetDoesNotExists_APIException;
    
    @GetMapping("/latest")
    ResponseEntity<List<CodeSnippetDTO>> getLatestCodeSnippets();
}
