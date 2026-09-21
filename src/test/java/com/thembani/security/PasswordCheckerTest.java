package com.thembani.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    private final PasswordChecker checker = new PasswordChecker();

    @Test
    void shouldAcceptPasswordWithMinimumLength() {
        assertTrue(checker.hasMinimumLength("Password"));
    }

    @Test
    void shouldRejectPasswordWithLessThanEightCharacters() {
        assertFalse(checker.hasMinimumLength("Pass123"));
    }

    @Test
    void shouldDetectUppercaseLetter() {
        assertTrue(checker.hasUppercase("Password123"));
    }

    @Test
    void shouldDetectLowercaseLetter() {
        assertTrue(checker.hasLowercase("Password123"));
    }

    @Test
    void shouldDetectNumber() {
        assertTrue(checker.hasNumber("Password123"));
    }

    @Test
    void shouldDetectSpecialCharacter() {
        assertTrue(checker.hasSpecialCharacter("Password123!"));
    }

    @Test
    void shouldCalculateStrongPasswordScore() {
        assertEquals(5, checker.calculateScore("Password123!"));
    }

    @Test
    void shouldIdentifyStrongPassword() {
        assertEquals("STRONG", checker.getStrength("Password123!"));
    }

    @Test
    void shouldIdentifyMediumPassword() {
        assertEquals("MEDIUM", checker.getStrength("Password123"));
    }

    @Test
    void shouldIdentifyWeakPassword() {
        assertEquals("WEAK", checker.getStrength("password"));
    }

    @Test
    void shouldHandleNullPassword() {
        assertEquals(0, checker.calculateScore(null));
        assertEquals("WEAK", checker.getStrength(null));
    }
}