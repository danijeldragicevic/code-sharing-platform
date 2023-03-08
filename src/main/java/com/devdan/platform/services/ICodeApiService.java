package com.devdan.platform.services;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExistsException;
import com.devdan.platform.models.Code;

public interface ICodeApiService {
    Code saveCodeSnippet(Code snippet);
    Code findCodeSnippetById(String id) throws CodeSnippetDoesNotExistsException;
}
