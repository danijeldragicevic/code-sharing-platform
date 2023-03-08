package com.devdan.platform.repositories;

import com.devdan.platform.models.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ICodeApiRepository extends JpaRepository<Code, String> {
    @Override
    Code save(Code entity);

    @Override
    Optional<Code> findById(String s);
}
