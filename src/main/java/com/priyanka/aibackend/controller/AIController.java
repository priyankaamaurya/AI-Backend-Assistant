package com.priyanka.aibackend.controller;

import com.priyanka.aibackend.dto.AIRequest;
import com.priyanka.aibackend.dto.AIResponse;
import com.priyanka.aibackend.entity.ChatHistory;
import com.priyanka.aibackend.service.AIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@Tag(
        name = "AI Assistant APIs",
        description = "APIs for interacting with AI and managing chat conversations"
)public class AIController {

    @Autowired
    private AIService aiService;

    private static final Logger log = LoggerFactory.getLogger(AIController.class);

    @PostMapping("/ask")
    @Operation(summary = "Ask AI", description = "Send prompt to AI and get response")
    public AIResponse askAI(@RequestBody AIRequest request) {

        log.info("Received request: {}", request.getPrompt());

        String result = aiService.getAIResponse(request.getPrompt());
        return new AIResponse(result, "success");
    }

    @GetMapping("/history")
    public List<ChatHistory> getChatHistory() {
        return aiService.getAllChats();
    }

}
