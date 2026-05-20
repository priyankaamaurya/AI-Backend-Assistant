package com.priyanka.aibackend.dto;

public class AIResponse {

    private String response;
    private String status;

    public AIResponse(String response, String status) {
        this.response = response;
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public String getStatus() {
        return status;
    }
}
