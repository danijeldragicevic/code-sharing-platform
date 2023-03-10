package com.devdan.platform.services;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_Exception;
import com.devdan.platform.models.CodeSnippet;

import java.util.List;

public interface ICodeSnippetService {
    CodeSnippet saveCodeSnippet(CodeSnippet codeSnippet);
    CodeSnippet getCodeSnippetById(String id) throws CodeSnippetDoesNotExists_Exception;
    CodeSnippet reduceCodeSnippetViewsAllowed(CodeSnippet codeSnippet);
    CodeSnippet reduceCodeSnippetSecondsAllowed(CodeSnippet codeSnippet);
    CodeSnippet deleteCodeSnippet(CodeSnippet codeSnippet);
    List<CodeSnippet> getLatestCodeSnippets();
}
