package com.devdan.platform.services.impl;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_Exception;
import com.devdan.platform.models.CodeSnippet;
import com.devdan.platform.repositories.ICodeSnippetRepository;
import com.devdan.platform.services.ICodeSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeSnippetServiceImpl implements ICodeSnippetService {
    private final ICodeSnippetRepository repository;
    
    @Override
    public CodeSnippet createCodeSnippet(CodeSnippet snippet) {
        return repository.save(snippet);
    }

    @Override
    public CodeSnippet getCodeSnippetById(String id) throws CodeSnippetDoesNotExists_Exception {
        Optional<CodeSnippet> code = repository.findById(id);
        if (!code.isEmpty()) {
            return code.get();
        } else {
            throw new CodeSnippetDoesNotExists_Exception();
        }
    }

    @Override
    public List<CodeSnippet> getLatestCodeSnippets() {
        return repository.findTop10ByTimeLimitedIsFalseAndViewLimitedIsFalseOrderByTimeCreatedDesc();
    }
}
