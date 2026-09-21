# Secure Password Checker

A command-line Java application that checks a password against five common security rules, gives it a score out of 5, and rates it **WEAK**, **MEDIUM** or **STRONG**. Built with Maven and covered by JUnit 5 unit tests.


## Features

- Checks five rules and shows a ✓ / ✗ for each one
- Calculates a score from 0 to 5
- Rates the password as WEAK, MEDIUM or STRONG
- Handles `null` input safely (scores 0, rated WEAK)
- Unit tested with JUnit 5

## How scoring works

Each rule the password passes adds 1 point:

| # | Rule                          |
|---|-------------------------------|
| 1 | At least 8 characters         |
| 2 | Contains an uppercase letter  |
| 3 | Contains a lowercase letter   |
| 4 | Contains a number             |
| 5 | Contains a special character  |

| Score | Strength |
|-------|----------|
| 0 – 2 | WEAK     |
| 3 – 4 | MEDIUM   |
| 5     | STRONG   |

A "special character" is anything that isn't a letter or a digit.

## Example output

```
================================
      SECURE PASSWORD CHECKER
================================
Enter password: Password123!

Password analysis:

✓ At least 8 characters
✓ Contains uppercase letter
✓ Contains lowercase letter
✓ Contains number
✓ Contains special character

Password score: 5/5
Password strength: STRONG
```

## Tech stack

- Java 17
- Maven
- JUnit 5 (5.10.2)
- Maven Surefire Plugin (3.2.5)

## Project structure

```
SecurePasswordChecker/
├── pom.xml
├── src/
│   ├── main/java/com/thembani/security/
│   │   ├── Main.java               # Console UI: reads input, prints the report
│   │   └── PasswordChecker.java    # Rule checks, scoring and strength rating
│   └── test/java/com/thembani/security/
│       └── PasswordCheckerTest.java
└── README.md
```

## Getting started

### Prerequisites

- JDK 17 or newer
- Maven 3.8+ (or just open the project in IntelliJ IDEA)

### Clone and build

```bash
git clone https://github.com/Thembani-tech/SecurePasswordChecker.git
```

### Run

```bash
java -cp target/classes com.thembani.security.Main
```

Or in IntelliJ: open `Main.java` and click the green run arrow next to `main`.

### Run the tests

```bash
mvn test
```

## Testing

The 11 unit tests in `PasswordCheckerTest` cover:

- Minimum length check (passing and failing cases)
- Uppercase, lowercase, number and special character detection
- Score calculation for a fully valid password
- WEAK, MEDIUM and STRONG classification
- `null` input handling

## Known limitations

- Length only counts as a single rule, so a short password that hits every other rule (e.g. `aA1!`) still scores 4/5 and is rated MEDIUM.
- It doesn't check against lists of common passwords (like `Password123!`, which this tool rates STRONG).
- It doesn't measure entropy or detect patterns such as `abc123` or repeated characters.
- The password is echoed on screen while typing.
- If the ✓ / ✗ symbols show up as `?` on Windows, switch the terminal to UTF-8 (`chcp 65001`) before running.

## Ideas for future improvements

- Add a common-password blacklist check
- Weight length more heavily in the score
- Hide the password while typing using `System.console()`
- Add more edge-case tests (spaces, Unicode, very long input)

## Author

**Thembani**, Software Development student at WeThinkCode_.