package com.priyanka.aibackend.controller;

import com.priyanka.aibackend.dto.AIRequest;
import com.priyanka.aibackend.dto.AIResponse;
import com.priyanka.aibackend.entity.ChatHistory;
import com.priyanka.aibackend.service.AIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    @Autowired
    private AIService aiService;

    private static final Logger log = LoggerFactory.getLogger(AIController.class);

    @PostMapping("/ask")
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
