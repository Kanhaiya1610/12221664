package com.backendtestsubmission;

import com.loggingmiddleware.LoggingMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BackendTestController {

    @Autowired
    private LoggingMiddleware loggingMiddleware;

    @GetMapping("/demo")
    public String demoEndpoint() {
        try {
            loggingMiddleware.log(
                "backend",
                "info",
                "controller",
                "Demo endpoint hit successfully",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiYXVkIjoiaHR0cDovLzIwLjI0NC41Ni4xNDQvZXZhbHVhdGlvbi1zZXJ2aWNlIiwiZW1haWwiOiJrbGFnZ2Fyd2FsMTYxMEBnbWFpbC5jb20iLCJleHAiOjE3NTI0NzA5MTEsImlhdCI6MTc1MjQ3MDAxMSwiaXNzIjoiQWZmb3JkIE1lZGljYWwgVGVjaG5vbG9naWVzIFByaXZhdGUgTGltaXRlZCIsImp0aSI6ImJlYTgzN2Y5LTcwNWQtNGJjNC04MzQzLTFiYTU1Y2ZmYmFiZSIsImxvY2FsZSI6ImVuLUlOIiwibmFtZSI6ImthbmhhaXlhIGxhbCIsInN1YiI6Ijk1M2MyMTY4LTBjZWItNDgzOS1hMmZiLTg0NTdlNmE2ODkzNyJ9LCJlbWFpbCI6ImtsYWdnYXJ3YWwxNjEwQGdtYWlsLmNvbSIsIm5hbWUiOiJrYW5oYWl5YSBsYWwiLCJyb2xsTm8iOiIxMjIyMTY2NCIsImFjY2Vzc0NvZGUiOiJDWnlwUUsiLCJjbGllbnRJRCI6Ijk1M2MyMTY4LTBjZWItNDgzOS1hMmZiLTg0NTdlNmE2ODkzNyIsImNsaWVudFNlY3JldCI6ImVBTWtObnVDZXVWV1BIckIifQ.ytJSbuMSTn-1UkdnPBLRtmeChniFgAtBYjE-VA6s3tg"
            );
            return "Demo endpoint response!";
        } catch (Exception e) {
            return "Logging failed: " + e.getMessage();
        }
    }
}
