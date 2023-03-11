package com.devdan.platform.controllers.impl;

import com.devdan.platform.controllers.ICodeSnippet_HtmlController;
import com.devdan.platform.dtos.CodeSnippetDTO;
import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_Exception;
import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_HtmlException;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.models.CodeSnippet;
import com.devdan.platform.services.ICodeSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CodeSnippet_HtmlControllerImpl implements ICodeSnippet_HtmlController {
    private final ICodeSnippetService service;
    private final IModelMapper mapper;
    
    @Override
    public String createCodeSnippet(Model model) {
        return "newCodeSnippet_Page";
    }

    @Override
    public String getCodeSnippetById(Model model, String id) throws CodeSnippetDoesNotExists_HtmlException {
        try {
            CodeSnippetDTO codeSnippetDTO = mapper.mapToDto(service.getCodeSnippetById(id)); 
            model.addAttribute("codeSnippetDTO", codeSnippetDTO);
            
            return "codeSnippetById_Page";
        } catch (CodeSnippetDoesNotExists_Exception e) {
            throw new CodeSnippetDoesNotExists_HtmlException(model);
        }
    }

    @Override
    public String getLatestCodeSnippets(Model model) {
        List<CodeSnippet> latestCodeSnippets = service.getLatestCodeSnippets();
        List<CodeSnippetDTO> latestCodeSnippetsDTOs = new ArrayList<>();
        for (CodeSnippet cs: latestCodeSnippets) {
            latestCodeSnippetsDTOs.add(mapper.mapToDto(cs));
        }
        model.addAttribute("latestCodeSnippetsDTOs", latestCodeSnippetsDTOs);
        
        return "latestCodeSnippets_Page";
    }
}
