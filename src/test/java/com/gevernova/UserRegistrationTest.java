package com.gevernova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    UserRegistration registration = new UserRegistration();
    //  Positive Test Cases

    @Test
    void testValidRegistrationWithDifferentInputs() {
        Assertions.assertDoesNotThrow(() ->
                registration.registerUser("john_doe", "john.doe123@mail.com", "passWord9"));
    }

    //  Negative Test Cases
    @Test
    void testInvalidUsername() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("", "test@example.com", "secure123"));
        Assertions.assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testUsernameWithOnlySpaces() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("   ", "test@example.com", "secure123"));
        Assertions.assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testNullUsername() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser(null, "test@example.com", "secure123"));
        Assertions.assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "invalidemail", "secure123"));
        Assertions.assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testEmailWithoutAtSymbol() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "email.com", "secure123"));
        Assertions.assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testNullEmail() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", null, "secure123"));
        Assertions.assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testValidRegexPassword() {
        Assertions.assertDoesNotThrow(() ->
                registration.registerUser("user", "user@example.com", "StrongPass9"));
    }


    @Test
    void testPasswordMissingUppercase() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "user@example.com", "password1"));
        Assertions.assertEquals("Password must be at least 8 characters long, contain one digit and one uppercase letter", exception.getMessage());
    }

    @Test
    void testPasswordMissingDigit() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "user@example.com", "PasswordOnly"));
        Assertions.assertEquals("Password must be at least 8 characters long, contain one digit and one uppercase letter", exception.getMessage());
    }

    @Test
    void testPasswordTooShort() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "user@example.com", "P1a"));
        Assertions.assertEquals("Password must be at least 8 characters long, contain one digit and one uppercase letter", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormatMissingDomain() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "name@", "Password1"));
        Assertions.assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormatMissingAt() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                registration.registerUser("user", "name.example.com", "Password1"));
        Assertions.assertEquals("Invalid email", exception.getMessage());
    }

}