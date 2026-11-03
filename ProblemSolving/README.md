# ProblemSolving

Java practice project for common array problems: duplicates, frequency counts, first non-repeating element, second largest distinct value, and unique elements.

## Requirements

- **JDK 21+**
- **Apache Maven 3.8+**

## Project layout

```
ProblemSolving/
├── pom.xml
├── README.md
└── src/main/java/com/example/springboot/problemsolving/
    └── ProblemSolving.java
```

## Build

```bash
mvn clean package
```

Produces `target/ProblemSolving-1.0-SNAPSHOT.jar`.

## Run (CLI)

### Option 1 — Maven exec (no JAR needed)

```bash
mvn compile exec:java
```

### Option 2 — Executable JAR

```bash
mvn clean package
java -jar target/ProblemSolving-1.0-SNAPSHOT.jar
```

## What it runs

`ProblemSolving` uses a sample array `{2, 4, 7, 2, 8, 4, 9, 2, 7}` and prints:

| Step | Method | Result (for sample) |
|------|--------|---------------------|
| Find duplicates | `findDuplicate` | `2 4 2 7` (values seen again) |
| Frequency map | `findfrequency` | counts per value |
| First non-repeating | `findFirstNonRepetingElement` | `8` |
| Second largest distinct | `findsecondLargestdistinctNumber` | `8` |
| Remove duplicates | `removeDuplicate` | unique values in order |

## IDE

Open the folder as a Maven project in NetBeans, IntelliJ, or VS Code/Cursor. The main class is:

`com.example.springboot.problemsolving.ProblemSolving`
