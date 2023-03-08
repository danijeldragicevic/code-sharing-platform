package com.devdan.platform.controllers.impl;

import com.devdan.platform.controllers.ICodeApiController;
import com.devdan.platform.dtos.CodeDTO;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.models.Code;
import com.devdan.platform.services.ICodeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CodeApiControllerImpl implements ICodeApiController {
    private final IModelMapper mapper;
    private final ICodeApiService service;
    
    @Override
    public ResponseEntity<Map<String, String>> createCodeSnippet(CodeDTO codeDTO) {
        Code code = mapper.mapToModel(codeDTO);
        service.saveCodeSnippet(code);
        codeDTO = mapper.mapToDto(code);
        
        return ResponseEntity.ok(Map.of("code", codeDTO.getId()));
    }

    @Override
    public ResponseEntity<CodeDTO> getCodeSnippet(String id) {
        Code code = service.findCodeSnippetById(id);
        CodeDTO codeDTO = mapper.mapToDto(code);
        
        return ResponseEntity.ok(codeDTO);
    }
}
