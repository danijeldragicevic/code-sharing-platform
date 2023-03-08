package com.devdan.platform.controllers.impl;

import com.devdan.platform.controllers.ICodeHtmlController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class CodeHtmlControllerImpl implements ICodeHtmlController {
    @Override
    public String createCodeSnippet(Model model) {
        return "codeNew";
    }
}
