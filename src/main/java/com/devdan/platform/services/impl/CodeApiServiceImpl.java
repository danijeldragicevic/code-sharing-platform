package com.devdan.platform.services.impl;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExistsException;
import com.devdan.platform.models.CodeSnippet;
import com.devdan.platform.repositories.ICodeApiRepository;
import com.devdan.platform.services.ICodeApiService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CodeApiServiceImpl implements ICodeApiService {
    private final ICodeApiRepository repository;
    
    @Override
    public CodeSnippet createCodeSnippet(CodeSnippet snippet) {
        return repository.save(snippet);
    }

    @Override
    public CodeSnippet getCodeSnippetById(String id) throws CodeSnippetDoesNotExistsException {
        Optional<CodeSnippet> code = repository.findById(id);
        if (!code.isEmpty()) {
            return code.get();
        } else {
            throw new CodeSnippetDoesNotExistsException();
        }
    }

    @Override
    public List<CodeSnippet> getLatestCodeSnippets() {
        return repository.findTop10ByTimeLimitedIsFalseOrViewLimitedIsFalseOrderByTimeCreatedDesc();
    }
}
