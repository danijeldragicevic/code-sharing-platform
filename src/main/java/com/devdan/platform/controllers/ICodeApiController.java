package com.devdan.platform.controllers;

import com.devdan.platform.dtos.CodeSnippetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/api/code")
public interface ICodeApiController {
    @PostMapping(path = "/new")
    @ResponseBody
    ResponseEntity<Map<String, String>> createCodeSnippet(@RequestBody @Valid CodeSnippetDTO codeSnippetDTO);
    
    @GetMapping("/{id}")
    ResponseEntity<CodeSnippetDTO> getCodeSnippetById(@PathVariable String id);
    
    @GetMapping("/latest")
    ResponseEntity<List<CodeSnippetDTO>> getLatestCodeSnippets();
}
