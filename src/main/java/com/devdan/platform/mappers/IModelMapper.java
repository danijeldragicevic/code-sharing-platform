package com.devdan.platform.mappers;

import com.devdan.platform.dtos.CodeDTO;
import com.devdan.platform.models.Code;

public interface IModelMapper {
    Code mapToModel(CodeDTO codeDTO);
    CodeDTO mapToDto(Code code);
}
