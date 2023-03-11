package com.devdan.platform.controllers;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_HtmlException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/code")
public interface ICodeSnippet_HtmlController {
    @GetMapping("/new")
    String createCodeSnippet(Model model);
    
    @GetMapping("/{id}")
    String getCodeSnippetById(Model model, @PathVariable("id") String id) throws CodeSnippetDoesNotExists_HtmlException;
    
    @GetMapping("/latest")
    String getLatestCodeSnippets(Model model);
}
