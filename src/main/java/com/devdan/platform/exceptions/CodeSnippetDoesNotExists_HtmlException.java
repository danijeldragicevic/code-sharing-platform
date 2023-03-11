package com.devdan.platform.exceptions;

import org.springframework.ui.Model;

public class CodeSnippetDoesNotExists_HtmlException extends RuntimeException {
    public CodeSnippetDoesNotExists_HtmlException(Model model) {
    }
}
