package com.devdan.platform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "code_snippets")
public class CodeSnippet {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "time_created")
    private LocalDateTime timeCreated;
    
    @Column(name = "views_allowed")
    private long viewsAllowed;
    
    @Column(name = "view_limited")
    private boolean viewLimited;
    
    @Column(name = "seconds_allowed")
    private long secondsAllowed;
    
    @Column(name = "time_limited")
    private boolean timeLimited;
}
