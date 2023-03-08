package com.devdan.platform.services;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExistsException;
import com.devdan.platform.models.CodeSnippet;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ICodeApiService {
    CodeSnippet createCodeSnippet(CodeSnippet snippet);
    CodeSnippet getCodeSnippetById(String id) throws CodeSnippetDoesNotExistsException;
    List<CodeSnippet> getLatestCodeSnippets();
}
