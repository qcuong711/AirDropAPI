package com.example.demo.repository;

import com.example.demo.entity.TokenHeader;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TokenRepository extends JpaRepository<TokenHeader, Long> {

    List<TokenHeader> findByOrderByIdDesc(Pageable pageable);
}
