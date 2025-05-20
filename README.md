#  Java Unit Testing with JUnit 5

Writing **automated tests** in Java using the **JUnit 5 framework**. This branch includes test-driven examples to help you confidently validate your logic and catch bugs early.

---

##  What's Inside?

Each file in this branch showcases how to write clean, efficient, and meaningful tests using JUnit 5 (Jupiter API).

---

##  Branch Overview

### 🔹 JUnit Foundations
Understand how unit testing supports maintainable and bug-free code.

### 🔹 Annotations That Matter
Explore the lifecycle of test execution using:
- `@Test`
- `@BeforeEach`, `@AfterEach`
- `@BeforeAll`, `@AfterAll`
- `@DisplayName` and `@Disabled`

### 🔹 Structuring Your Test Code
Learn how to:
- Separate test logic from production logic
- Follow naming conventions
- Use nested classes for context grouping

### 🔹 Assertions You Should Know
Test expectations with:
- `assertEquals()`, `assertTrue()`, `assertFalse()`
- `assertThrows()` for exception testing
- `assertAll()` for grouped assertions

---

## 📦 Maven Setup

To start writing tests with JUnit 5, include the following in your `pom.xml`:

```xml
<dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.10.0</version> 
            <scope>test</scope>
        </dependency>
    </dependencies>

