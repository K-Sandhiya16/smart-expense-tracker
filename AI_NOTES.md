# AI Collaboration Notes

## 1. Code Generation Breakdown
* **AI-Generated:** Project initial setup, DTO structure, and controller mappings.
* **Written/Refactored by Me:** Business service logic using concurrent state handling (`ConcurrentHashMap`), validation rules (`@Valid`, `@Positive`), and Spring Boot integration tests.

## 2. Validation & Quality Adjustments
* **`BigDecimal` over `double`:** Switched monetary values to `BigDecimal` to ensure precise floating-point decimal operations without rounding glitches.
* **Concurrency:** Selected `ConcurrentHashMap` for local storage to maintain thread safety across concurrent HTTP API calls.
* **Input Constraints:** Applied strict annotation checks (`@NotBlank`, `@NotNull`, `@Positive`) to prevent invalid records from being created.

## 3. Discarded AI Suggestions
* **Database Integration (H2/JPA):** Declined database layer suggestions. Storing items safely in memory satisfies all task criteria while maintaining zero setup dependencies and high performance.