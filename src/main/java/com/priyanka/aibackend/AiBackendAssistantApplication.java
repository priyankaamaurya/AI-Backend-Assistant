package com.priyanka.aibackend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiBackendAssistantApplication {

    public static final Dotenv dotenv = Dotenv.load();

	public static void main(String[] args) {

        // Load env variables at startup
        Dotenv dotenv = Dotenv.load();

        String apiKey = dotenv.get("openrouter.api.key");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("openrouter.api.key is missing in .env file");
        }

        System.setProperty("openrouter.api.key", apiKey);

		SpringApplication.run(AiBackendAssistantApplication.class, args);
	}

}
