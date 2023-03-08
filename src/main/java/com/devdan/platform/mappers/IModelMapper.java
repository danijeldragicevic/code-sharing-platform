package com.devdan.platform.mappers;

import com.devdan.platform.dtos.CodeSnippetDTO;
import com.devdan.platform.models.CodeSnippet;

public interface IModelMapper {
    CodeSnippet mapToModel(CodeSnippetDTO codeSnippetDTO);
    CodeSnippetDTO mapToDto(CodeSnippet codeSnippet);
}
