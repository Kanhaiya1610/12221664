package com.backendtestsubmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.backendtestsubmission", "com.loggingmiddleware"})
public class BackendTestSubmissionApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendTestSubmissionApplication.class, args);
    }
}
