package com.devdan.platform.services;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_Exception;
import com.devdan.platform.models.CodeSnippet;

import java.util.List;

public interface ICodeSnippetService {
    CodeSnippet createCodeSnippet(CodeSnippet snippet);
    CodeSnippet getCodeSnippetById(String id) throws CodeSnippetDoesNotExists_Exception;
    List<CodeSnippet> getLatestCodeSnippets();
}
