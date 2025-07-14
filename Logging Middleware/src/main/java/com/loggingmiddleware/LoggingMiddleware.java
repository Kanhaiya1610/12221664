package com.loggingmiddleware;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoggingMiddleware {
    private static final Set<String> ALLOWED_STACKS = new HashSet<>(Arrays.asList("backend", "frontend"));
    private static final Set<String> ALLOWED_LEVELS = new HashSet<>(Arrays.asList("debug", "info", "warn", "error", "fatal"));
    private static final Set<String> ALLOWED_PACKAGES = new HashSet<>(Arrays.asList(
            // Backend only
            "cache", "controller", "cron_job", "db", "domain", "handler", "repository", "route", "service",
            // Frontend only
            "api", "component", "hook", "page", "state", "style",
            // Both
            "auth", "config", "middleware", "utils"
    ));

    public void log(String stack, String level, String pkg, String message, String accessToken) throws Exception {
        if (!ALLOWED_STACKS.contains(stack)) throw new Exception("Invalid stack: " + stack);
        if (!ALLOWED_LEVELS.contains(level)) throw new Exception("Invalid level: " + level);
        if (!ALLOWED_PACKAGES.contains(pkg)) throw new Exception("Invalid package: " + pkg);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://20.244.56.144/evaluation-service/logs";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        String body = String.format(
                "{\"stack\":\"%s\",\"level\":\"%s\",\"package\":\"%s\",\"message\":\"%s\"}",
                stack, level, pkg, message
        );

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Log API error: " + response.getBody());
        }
    }
}