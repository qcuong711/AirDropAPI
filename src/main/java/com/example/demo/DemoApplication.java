package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner openBrowserOnStartup() {
        return args -> {
            String swaggerUrl = "http://localhost:8080/swagger-ui/index.html";

            // Check if the Desktop API is supported
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                // Open the Swagger UI page in the default browser
                Desktop.getDesktop().browse(new URI(swaggerUrl));
            } else {
                // Fallback for environments where Desktop is not supported (e.g., headless servers)
                System.out.println("Please open your browser and navigate to: " + swaggerUrl);
            }
        };
    }
}
