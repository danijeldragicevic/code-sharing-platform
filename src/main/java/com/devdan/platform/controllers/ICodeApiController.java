package com.devdan.platform.controllers;

import com.devdan.platform.dtos.CodeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/code")
public interface ICodeApiController {
    @PostMapping(path = "/new")
    ResponseEntity<Map<String, String>> createSnippet(@RequestBody @Valid CodeDTO codeDTO);
}
