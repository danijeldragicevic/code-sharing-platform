package com.devdan.platform.services.impl;

import com.devdan.platform.models.Code;
import com.devdan.platform.repositories.ICodeApiRepository;
import com.devdan.platform.services.ICodeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeApiServiceImpl implements ICodeApiService {
    private final ICodeApiRepository repository;
    
    @Override
    public Code save(Code entity) {
        return repository.save(entity);
    }
}
