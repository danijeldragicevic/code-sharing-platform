package com.devdan.platform.mappers.impl;

import com.devdan.platform.dtos.CodeSnippetDTO;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.models.CodeSnippet;
import com.devdan.platform.utils.Util;

public class ModelMapperImpl implements IModelMapper {
    
    @Override
    public CodeSnippet mapToModel(CodeSnippetDTO codeSnippetDTO) {
        CodeSnippet codeSnippet = new CodeSnippet();
        codeSnippet.setId(Util.getNewUUID());
        codeSnippet.setCode(codeSnippetDTO.getCode());
        codeSnippet.setTimeCreated(Util.getCurrentDateTime());
        if (codeSnippetDTO.getViewsAllowed() > 0) {
            codeSnippet.setViewsAllowed(codeSnippetDTO.getViewsAllowed());
            codeSnippet.setViewLimited(true);
        }
        if (codeSnippetDTO.getSecondsAllowed() > 0) {
            codeSnippet.setSecondsAllowed(codeSnippetDTO.getSecondsAllowed());
            codeSnippet.setTimeLimited(true);
        }
        
        return codeSnippet;
    }

    @Override
    public CodeSnippetDTO mapToDto(CodeSnippet codeSnippet) {
        CodeSnippetDTO codeSnippetDTO = new CodeSnippetDTO();
        codeSnippetDTO.setId(codeSnippet.getId());
        codeSnippetDTO.setCode(codeSnippet.getCode());
        codeSnippetDTO.setTimeCreated(Util.formatDateTime(codeSnippet.getTimeCreated()));
        codeSnippetDTO.setSecondsAllowed(codeSnippet.getSecondsAllowed());
        codeSnippetDTO.setViewsAllowed(codeSnippet.getViewsAllowed());
        
        return codeSnippetDTO;
    }
}
