package com.priyanka.aibackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class AIRequest {

    @Schema(description = "User input prompt", example = "What is Java?")
    private String prompt;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
