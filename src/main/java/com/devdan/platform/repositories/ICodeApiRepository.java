package com.devdan.platform.repositories;

import com.devdan.platform.models.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ICodeApiRepository extends JpaRepository<Code, String> {
    @Override
    Code save(Code entity);
}
