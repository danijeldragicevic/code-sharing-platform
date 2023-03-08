package com.devdan.platform.repositories;

import com.devdan.platform.models.CodeSnippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICodeApiRepository extends JpaRepository<CodeSnippet, String> {
    List<CodeSnippet> findTop10ByTimeLimitedIsFalseAndViewLimitedIsFalseOrderByTimeCreatedDesc();
}
