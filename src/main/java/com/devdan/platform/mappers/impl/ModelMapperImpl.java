package com.devdan.platform.mappers.impl;

import com.devdan.platform.dtos.CodeDTO;
import com.devdan.platform.mappers.IModelMapper;
import com.devdan.platform.models.Code;
import com.devdan.platform.utils.Util;

import java.util.UUID;

public class ModelMapperImpl implements IModelMapper {
    
    @Override
    public Code mapToModel(CodeDTO codeDTO) {
        Code code = new Code();
        code.setId(Util.getNewUUID());
        code.setCodeSnippet(codeDTO.getCodeSnippet());
        code.setTimeCreated(Util.getCurrentDateTime());
        if (codeDTO.getViewsAllowed() > 0) {
            code.setViewsAllowed(codeDTO.getViewsAllowed());
            code.setViewLimited(true);
        }
        if (codeDTO.getSecondsAllowed() > 0) {
            code.setSecondsAllowed(codeDTO.getSecondsAllowed());
            code.setTimeLimited(true);
        }
        
        return code;
    }

    @Override
    public CodeDTO mapToDto(Code code) {
        CodeDTO codeDTO = new CodeDTO();
        codeDTO.setId(code.getId());
        codeDTO.setCodeSnippet(code.getCodeSnippet());
        codeDTO.setTimeCreated(Util.formatDateTime(code.getTimeCreated()));
        codeDTO.setSecondsAllowed(code.getSecondsAllowed());
        codeDTO.setViewsAllowed(code.getViewsAllowed());
        
        return codeDTO;
    }
}
