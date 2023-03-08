package com.devdan.platform.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CodeDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;
    
    @NotBlank(message = "Property code can not be empty!")
    @JsonProperty(value = "code")
    private String codeSnippet;
    
    @JsonProperty(value = "date")
    private String timeCreated;
    
    @JsonProperty(value = "time")
    private long secondsAllowed;
    
    @JsonProperty(value = "views")
    private long viewsAllowed;
}
