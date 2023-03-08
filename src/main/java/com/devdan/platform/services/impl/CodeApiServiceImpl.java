package com.devdan.platform.services.impl;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExistsException;
import com.devdan.platform.models.Code;
import com.devdan.platform.repositories.ICodeApiRepository;
import com.devdan.platform.services.ICodeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeApiServiceImpl implements ICodeApiService {
    private final ICodeApiRepository repository;
    
    @Override
    public Code saveCodeSnippet(Code snippet) {
        return repository.save(snippet);
    }

    @Override
    public Code findCodeSnippetById(String id) throws CodeSnippetDoesNotExistsException {
        Optional<Code> code = repository.findById(id);
        if (!code.isEmpty()) {
            return code.get();
        } else {
            throw new CodeSnippetDoesNotExistsException();
        }
    }
}
