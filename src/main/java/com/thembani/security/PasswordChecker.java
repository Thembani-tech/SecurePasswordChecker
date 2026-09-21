package com.thembani.security;

public class PasswordChecker {

    public boolean hasMinimumLength(String password) {
        return password != null && password.length() >= 8;
    }

    public boolean hasUppercase(String password) {
        if (password == null) {
            return false;
        }

        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasLowercase(String password) {
        if (password == null) {
            return false;
        }

        for (char character : password.toCharArray()) {
            if (Character.isLowerCase(character)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasNumber(String password) {
        if (password == null) {
            return false;
        }

        for (char character : password.toCharArray()) {
            if (Character.isDigit(character)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasSpecialCharacter(String password) {
        if (password == null) {
            return false;
        }

        for (char character : password.toCharArray()) {
            if (!Character.isLetterOrDigit(character)) {
                return true;
            }
        }

        return false;
    }

    public int calculateScore(String password) {
        if (password == null) {
            return 0;
        }

        int score = 0;

        if (hasMinimumLength(password)) {
            score++;
        }

        if (hasUppercase(password)) {
            score++;
        }

        if (hasLowercase(password)) {
            score++;
        }

        if (hasNumber(password)) {
            score++;
        }

        if (hasSpecialCharacter(password)) {
            score++;
        }

        return score;
    }

    public String getStrength(String password) {
        int score = calculateScore(password);

        if (score <= 2) {
            return "WEAK";
        } else if (score <= 4) {
            return "MEDIUM";
        } else {
            return "STRONG";
        }
    }
}