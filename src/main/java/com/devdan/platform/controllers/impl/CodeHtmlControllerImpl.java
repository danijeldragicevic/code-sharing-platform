package com.devdan.platform.controllers.impl;

import com.devdan.platform.controllers.ICodeHtmlController;
import com.devdan.platform.dtos.CodeSnippetDTO;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.services.ICodeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class CodeHtmlControllerImpl implements ICodeHtmlController {
    private final ICodeApiService service;
    private final IModelMapper mapper;
    
    @Override
    public String createCodeSnippet(Model model) {
        return "codeNew";
    }

    @Override
    public String getCodeSnippetById(Model model, String id) {
        CodeSnippetDTO codeSnippetDTO = mapper.mapToDto(service.getCodeSnippetById(id)); 
        
        model.addAttribute("code", codeSnippetDTO);
        
        return "codeSnippet";
    }
}
