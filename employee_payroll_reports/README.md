# Employee Payroll Reports

Console application for employee payroll queries and updates (filter by department, salary reports, increments, and more).

Built with **Spring Boot 3.3.4** and **Maven**.

## Requirements

| Tool   | Version                          |
|--------|----------------------------------|
| Java   | **21** (or newer JDK 21+)        |
| Maven  | 3.8+ (or use the Maven wrapper if available) |

Confirm your Java version:

```bash
java -version
```

You should see something like `openjdk version "21..."`.

## Project structure

```
employee_payroll_reports/
├── pom.xml
└── src/main/java/com/example/springboot/employee_payroll_reports/
    ├── EmployeePayroll.java          # Main entry point
    ├── Employee.java
    ├── EmployeeService.java
    ├── IncrementInfo.java
    └── InvalidEmployeeIdException.java
```

## Compile

From the project root:

```bash
mvn clean compile
```

To build an executable JAR:

```bash
mvn clean package
```

The JAR is written to:

```
target/employee_payroll_reports-1.0-SNAPSHOT.jar
```

## Run

### Option 1 — Maven Spring Boot plugin

```bash
mvn spring-boot:run
```

### Option 2 — Executable JAR

```bash
mvn clean package
java -jar target/employee_payroll_reports-1.0-SNAPSHOT.jar
```

### Option 3 — Compile and run the main class

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.example.springboot.employee_payroll_reports.EmployeePayroll"
```

The app starts an interactive menu. Enter a number (`0`–`11`) for the service you want; enter `0` to exit.

## NetBeans

1. Open the project (File → Open Project).
2. Ensure the project Java platform is set to JDK 21.
3. Run `EmployeePayroll` (right-click → Run File, or use the project Run action).
