package com.example.demo.service;

import com.example.demo.entity.TokenHeader;
import com.example.demo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public List<TokenHeader> getTokensByNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }

        Pageable pageable = PageRequest.of(0, number, Sort.by("id").descending());

        return tokenRepository.findByOrderByIdDesc(pageable);
    }

    public List<TokenHeader> findAllTokens() {
        return tokenRepository.findAll();
    }
}
