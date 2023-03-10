package com.devdan.platform.controllers.impl;

import com.devdan.platform.controllers.ICodeSnippet_ApiController;
import com.devdan.platform.dtos.CodeSnippetDTO;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.models.CodeSnippet;
import com.devdan.platform.services.ICodeSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CodeSnippet_ApiControllerImpl implements ICodeSnippet_ApiController {
    private final IModelMapper mapper;
    private final ICodeSnippetService service;
    
    @Override
    public ResponseEntity<Map<String, String>> createCodeSnippet(CodeSnippetDTO codeSnippetDTO) {
        CodeSnippet codeSnippet = mapper.mapToModel(codeSnippetDTO);
        service.saveCodeSnippet(codeSnippet);
        codeSnippetDTO = mapper.mapToDto(codeSnippet);
        
        return ResponseEntity.ok(Map.of("id", codeSnippetDTO.getId()));
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
