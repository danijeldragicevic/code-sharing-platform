package com.devdan.platform.controllers.impl;

import com.devdan.platform.controllers.ICodeApiController;
import com.devdan.platform.dtos.CodeSnippetDTO;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.models.CodeSnippet;
import com.devdan.platform.services.ICodeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CodeApiControllerImpl implements ICodeApiController {
    private final IModelMapper mapper;
    private final ICodeApiService service;
    
    @Override
    public ResponseEntity<Map<String, String>> createCodeSnippet(CodeSnippetDTO codeSnippetDTO) {
        CodeSnippet codeSnippet = mapper.mapToModel(codeSnippetDTO);
        service.createCodeSnippet(codeSnippet);
        codeSnippetDTO = mapper.mapToDto(codeSnippet);
        
        return ResponseEntity.ok(Map.of("code", codeSnippetDTO.getId()));
    }

    @Override
    public ResponseEntity<CodeSnippetDTO> getCodeSnippetById(String id) {
        CodeSnippet codeSnippet = service.getCodeSnippetById(id);
        CodeSnippetDTO codeSnippetDTO = mapper.mapToDto(codeSnippet);
        
        return ResponseEntity.ok(codeSnippetDTO);
    }

    @Override
    public ResponseEntity<List<CodeSnippetDTO>> getLatestCodeSnippets() {
        List<CodeSnippet> latestCodeSnippets = service.getLatestCodeSnippets();
        List<CodeSnippetDTO> latestCodeSnippetsDTOs = new ArrayList<>();
        for (CodeSnippet cs: latestCodeSnippets) {
            latestCodeSnippetsDTOs.add(mapper.mapToDto(cs));
        }
        
        return ResponseEntity.ok(latestCodeSnippetsDTOs);
    }
}
