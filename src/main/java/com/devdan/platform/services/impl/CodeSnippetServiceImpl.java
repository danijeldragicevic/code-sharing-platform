package com.devdan.platform.services.impl;

import com.devdan.platform.exceptions.CodeSnippetDoesNotExists_Exception;
import com.devdan.platform.models.CodeSnippet;
import com.devdan.platform.repositories.ICodeSnippetRepository;
import com.devdan.platform.services.ICodeSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeSnippetServiceImpl implements ICodeSnippetService {
    public static final int DEFAULT_VIEWS_VALUE = 0;
    public static final int DEFAULT_SECONDS_VALUE = 0;
    public static final int ZERO = 0;
    public static final int ONE = 1;

    private final ICodeSnippetRepository repository;
    
    @Override
    public CodeSnippet saveCodeSnippet(CodeSnippet codeSnippet) {
        return repository.save(codeSnippet);
    }

    @Override
    public CodeSnippet getCodeSnippetById(String id) throws CodeSnippetDoesNotExists_Exception {
        Optional<CodeSnippet> codeSnippet = repository.findById(id);
        
        if (codeSnippet.isEmpty()) {
            throw new CodeSnippetDoesNotExists_Exception();
        }
        
        if (codeSnippet.get().isTimeLimited() || codeSnippet.get().isViewLimited()) {
            reduceCodeSnippetSecondsAllowed(codeSnippet.get());
            reduceCodeSnippetViewsAllowed(codeSnippet.get());
            saveCodeSnippet(codeSnippet.get());
        }
        
        if ((codeSnippet.get().isTimeLimited() & codeSnippet.get().getSecondsAllowed() == ZERO) || 
            (codeSnippet.get().isViewLimited() & codeSnippet.get().getViewsAllowed() == ZERO)) {
            deleteCodeSnippet(codeSnippet.get());
        }
        
        return codeSnippet.get();
    }

    @Override
    public CodeSnippet reduceCodeSnippetViewsAllowed(CodeSnippet codeSnippet) {
        codeSnippet.setViewsAllowed(codeSnippet.getViewsAllowed() - ONE);
        if (codeSnippet.getViewsAllowed() <= ZERO) {
            codeSnippet.setViewsAllowed(DEFAULT_VIEWS_VALUE);
        }
        
        return codeSnippet;
    }

    @Override
    public CodeSnippet reduceCodeSnippetSecondsAllowed(CodeSnippet codeSnippet) {
        long secondsAvailable = ChronoUnit.SECONDS.between(codeSnippet.getTimeCreated(), LocalDateTime.now());
        codeSnippet.setSecondsAllowed(codeSnippet.getSecondsAllowed() - secondsAvailable);
        if (codeSnippet.getSecondsAllowed() <= ZERO) {
            codeSnippet.setSecondsAllowed(DEFAULT_SECONDS_VALUE);
        }
        
        return codeSnippet;
    }

    @Override
    public CodeSnippet deleteCodeSnippet(CodeSnippet codeSnippet) {
        repository.delete(codeSnippet);
        
        return codeSnippet;
    }

    @Override
    public List<CodeSnippet> getLatestCodeSnippets() {
        return repository.findTop10ByTimeLimitedIsFalseAndViewLimitedIsFalseOrderByTimeCreatedDesc();
    }
}
