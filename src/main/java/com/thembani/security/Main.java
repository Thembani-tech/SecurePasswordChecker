package com.thembani.security;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        System.out.println("================================");
        System.out.println("      SECURE PASSWORD CHECKER");
        System.out.println("================================");

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println();
        System.out.println("Password analysis:");
        System.out.println();

        System.out.println(
                (checker.hasMinimumLength(password) ? "✓" : "✗")
                        + " At least 8 characters"
        );

        System.out.println(
                (checker.hasUppercase(password) ? "✓" : "✗")
                        + " Contains uppercase letter"
        );

        System.out.println(
                (checker.hasLowercase(password) ? "✓" : "✗")
                        + " Contains lowercase letter"
        );

        System.out.println(
                (checker.hasNumber(password) ? "✓" : "✗")
                        + " Contains number"
        );

        System.out.println(
                (checker.hasSpecialCharacter(password) ? "✓" : "✗")
                        + " Contains special character"
        );

        System.out.println();
        System.out.println("Password score: "
                + checker.calculateScore(password) + "/5");

        System.out.println("Password strength: "
                + checker.getStrength(password));

        scanner.close();
    }
}