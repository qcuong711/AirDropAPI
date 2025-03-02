package com.example.demo.controller;

import com.example.demo.entity.TokenHeader;
import com.example.demo.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tokens")
@Tag(name = "Token Controller", description = "APIs for managing tokens")
public class TokenController {
    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService TokenService) {
        this.tokenService = TokenService;
    }

    @GetMapping("/top")
    @Operation(
            summary = "Get all tokens with a filter",
            description = "Returns a list of tokens filtered by the provided parameter",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved tokens"),
                    @ApiResponse(responseCode = "404", description = "No tokens found")
            }
    )
    public List<TokenHeader> getTopTokens(
            @Parameter(description = "Filter to apply to tokens", example = "20")
            @RequestParam(defaultValue = "20") int limit) {
        return tokenService.getTokensByNumber(limit);
    }
}
