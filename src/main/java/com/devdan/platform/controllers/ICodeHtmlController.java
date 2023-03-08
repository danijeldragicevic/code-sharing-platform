package com.devdan.platform.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/code")
public interface ICodeHtmlController {
    @GetMapping("/new")
    String createCodeSnippet(Model model);
}
