package com.gevernova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Strong1Pass"));
    }

    @Test
    void testTooShortPassword() {
        assertFalse(PasswordValidator.isValid("S1p"));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(PasswordValidator.isValid("strong123"));
    }

    @Test
    void testMissingDigit() {
        assertFalse(PasswordValidator.isValid("StrongPass"));
    }
    //Negative
    @Test
    void testMissingSpecialCharacter() {
        assertFalse(PasswordValidator.isValid("StrongPass"));
    }
    @Test
    void testPasswordWithSpecialCharsOnly() {
        Assertions.assertFalse(validator.isValid("!@#$%^&*()"));
    }

}
