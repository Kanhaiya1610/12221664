# Logging Middleware

This is a reusable logging middleware package developed for the Affordmed evaluation.

## Features

- Provides a `log()` function to send structured logs to the Affordmed evaluation server.
- Validates log parameters (`stack`, `level`, `package`) as per allowed values.
- Handles API authentication using Bearer token.
- Can be integrated into any Java Spring Boot backend.

## Usage

1. **Build the middleware:**
    ```sh
    mvn clean install
    ```
    This will generate a JAR file in the `target/` directory.

2. **Add as a dependency** in your backend project (see Backend Test Submission for example).

3. **Import and use:**
    ```java
    import com.loggingmiddleware.LoggingMiddleware;
    // ...
    loggingMiddleware.log("backend", "info", "controller", "Your log message", "YOUR_ACCESS_TOKEN");
    ```

## Allowed Values

- **stack:** `backend`, `frontend`
- **level:** `debug`, `info`, `warn`, `error`, `fatal`
- **package:**  
  - Backend: `cache`, `controller`, `cron_job`, `db`, `domain`, `handler`, `repository`, `route`, `service`
  - Frontend: `api`, `component`, `hook`, `page`, `state`, `style`
  - Both: `auth`, `config`, `middleware`, `utils`

```
## Project Structure

Logging Middleware/
├── pom.xml
└── src/
└── main/
└── java/
└── com/
└── loggingmiddleware/
└── LoggingMiddleware.java

```

---

## **Backend Test Submission/README.md**

```markdown
# Backend Test Submission

This is a sample Spring Boot backend application that demonstrates the usage of the Logging Middleware.

## Features

- Exposes a `/api/demo` endpoint.
- On hitting the endpoint, sends a log to the Affordmed evaluation server using the Logging Middleware.
- Handles and displays log API responses.

## How to Run

1. **Ensure Logging Middleware is built:**
    ```sh
    cd "../Logging Middleware"
    mvn clean install
    ```

2. **Build and run the backend:**
    ```sh
    cd "../Backend Test Submission"
    mvn clean install
    mvn spring-boot:run
    ```

3. **Test the endpoint:**
    - Open browser or Postman:
      ```
      http://localhost:8080/api/demo
      ```
    - You should see a success message if logging works.

## Project Structure

```
```
Backend Test Submission/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── backendtestsubmission/
                    ├── BackendTestSubmissionApplication.java
                    └── BackendTestController.java
```

```
Backend Test Submission/
├── pom.xml
└── src/
└── main/
└── java/
└── com/
└── backendtestsubmission/
├── BackendTestSubmissionApplication.java
└── BackendTestController.java
```
## Example Response
{
    "logID": "32864666-7ee1-4eac-a54a-62a191b72b46",
    "message": "log created successfully"
}

```
## Notes

- Replace `"YOUR_ACCESS_TOKEN"` in the controller with your valid Affordmed access token.
- Make sure to keep your access token secure and do not commit it to public repositories.

---

