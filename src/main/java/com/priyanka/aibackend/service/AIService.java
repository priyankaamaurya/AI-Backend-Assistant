package com.priyanka.aibackend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.priyanka.aibackend.entity.ChatHistory;
import com.priyanka.aibackend.repository.ChatHistoryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.*;
import static reactor.netty.http.HttpConnectionLiveness.log;

@Service
public class AIService {

    private final WebClient webClient;
    private final ChatHistoryRepository repository;

    @Value("${openrouter.api.key}")
    private String apiKey;

    // Constructor Injection
    public AIService(WebClient webClient, ChatHistoryRepository repository) {
        this.webClient = webClient;
        this.repository = repository;
    }

    public String getAIResponse(String prompt) {
        try {
            log.info("User prompt: {}", prompt);

            // 🔹 Request Body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "openai/gpt-3.5-turbo");

            List<Map<String, String>> messages = new ArrayList<>();
            Map<String, String> message = new HashMap<>();
            message.put("role", "user");
            message.put("content", prompt);

            messages.add(message);
            requestBody.put("messages", messages);

            // 🔹 API Call
            String response = webClient.post()
                    .uri("/chat/completions")
                    .header("Authorization", "Bearer " + apiKey)
                    .header("HTTP-Referer", "http://localhost:8080")
                    .header("X-Title", "AI Backend Project")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            log.info("AI response received");

            // 🔹 Parse Response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response);

            String aiResponse = jsonNode
                    .get("choices")
                    .get(0)
                    .get("message")
                    .get("content")
                    .asText();

            // 🔥 SAVE TO DATABASE
            ChatHistory chat = new ChatHistory();
            chat.setPrompt(prompt);
            chat.setResponse(aiResponse);

            repository.save(chat);

            log.info("Chat saved to database");

            return aiResponse;

        } catch (Exception e) {
            log.error("Error in AIService: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ChatHistory> getAllChats() {
        return repository.findAllByOrderByCreatedAtDesc();
    }
}