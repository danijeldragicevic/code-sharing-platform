package com.devdan.platform.services;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExistsException;
import com.devdan.platform.models.CodeSnippet;

import java.util.List;

public interface ICodeApiService {
    CodeSnippet createCodeSnippet(CodeSnippet snippet);
    CodeSnippet getCodeSnippetById(String id) throws CodeSnippetDoesNotExistsException;
    List<CodeSnippet> getLatestCodeSnippets();
}
