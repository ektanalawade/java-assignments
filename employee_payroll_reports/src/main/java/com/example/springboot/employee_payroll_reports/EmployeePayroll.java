/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.example.springboot.employee_payroll_reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ekata
 *
 *
 */
public class EmployeePayroll {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1L, "Rahul", "IT", 80000, 6, "rahul@test.com"),
                new Employee(2L, "Priya", "HR", 65000, 5, "priya@test.com"),
                new Employee(3L, "Amit", "IT", 95000, 8, "amit@test.com"),
                new Employee(4L, "Sneha", "Finance", 70000, 7, "sneha@test.com"),
                new Employee(5L, "Raj", "IT", 85000, 4, "raj@test.com"),
                new Employee(6L, "Neha", "HR", 75000, 9, "neha@test.com")
        ));

        EmployeeService employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Service Executor Initialized ===");

        while (running) {
            printMenu();
            System.out.println("Enter your choice: ");
            // System.out.flush(); // 🔥 FORCE the text to display on the screen immediately

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.println(employeeService.findAllEmployeesByDepartment(employees, "IT").toString());
                    break;
                case "2":
                    System.out.println(employeeService.findAllEmployeesWithSalaryGreaterThan75K(employees));
                    break;
                case "3":
                    System.out.println(employeeService.findEmployeeWithHighestSalary(employees));
                    break;
                case "4":
                    System.out.println(employeeService.DepartmentWiseAvgSalary(employees));
                    break;
                case "5":
                    System.out.println(employeeService.DepartmentWiseEmployees(employees));
                    break;
                case "6":
                    System.out.println(employeeService.secondHighestDistinctSalary(employees));
                    break;
                case "7":
                    System.out.println(employeeService.SortEmployeeBySalaryDecendingOrder(employees));
                    break;
                case "8":
                    System.out.println(employeeService.findHighestPaidEmployeeByDepartment(employees));
                    break;
                case "9":
                    System.out.println(employeeService.findDuplicateEmailAddresss(employees));
                    break;
                case "10":
                    Employee employee;
                    try {
                        employee = getEmployeeInformation(scanner);
                    } catch (InvalidEmployeeIdException ex) {
                        System.out.println("Exception occured.." + ex.toString());
                        break;
                    }
                    employees.add(employee);
                    System.out.println("Updated List: " + employees.toString());
                    break;
                case "11":
                    IncrementInfo incrementInfo;
                    try {
                        incrementInfo = getPercentageIncrement(scanner);
                    } catch (InvalidEmployeeIdException ex) {
                        System.out.println("Exception occured.." + ex.toString());
                        break;
                    }
                    employeeService.incrementEmployeeSalaryByPercentage(employees, incrementInfo);
                    break;
                case "0":
                    System.out.println("\nExiting system!");
                    running = false;
                    break;
                default:
                    System.out.println("\n[Error] Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n---------------------------------");
        System.out.println("Available Services:");
        System.out.println("1. Find all employees belonging to IT.");
        System.out.println("2. Find employees with salary greater than 75,000.");
        System.out.println("3. Find the employee with the highest salary.");
        System.out.println("4. Calculate average salary overall and department-wise.");
        System.out.println("5. Group employees by department.");
        System.out.println("6. Find the second-highest distinct salary.");
        System.out.println("7. Sort employees by salary descending.");
        System.out.println("8. Find the highest-paid employee in each department.");
        System.out.println("9. Find duplicate email addresses.");
        System.out.println("10. Add Employee.");
        System.out.println("11. employee salary-increment.");
        System.out.println("0. Exit");
        System.out.println("---------------------------------");
    }

    private static Employee getEmployeeInformation(Scanner scanner) throws InvalidEmployeeIdException {
        System.out.println("\n--- Enter Employee Details ---");

        long empId = 0;
        while (true) {
            System.out.println("Enter employee ID: ");
            try {
                empId = Long.parseLong(scanner.nextLine().trim());
                if (empId > 0) {
                    break;
                }
                throw new InvalidEmployeeIdException("[Invalid Input] Employee ID cannot be zero or negative.");

                //System.out.println("[Invalid Input] Employee ID cannot be negative.");
            } catch (NumberFormatException e) {
                throw new InvalidEmployeeIdException("[Invalid Input] Please enter a valid whole number for employeeId.", e.getCause());
                // System.out.println("[Invalid Input] Please enter a valid whole number for employeeId.");
            }
        }

        String name = "";
        while (true) {
            System.out.println("Enter employee name: ");
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("[Invalid Input] Name cannot be empty.");
        }

        String department = "";
        while (true) {
            System.out.println("Enter employee department: ");
            department = scanner.nextLine().trim();
            if (!department.isEmpty()) {
                break;
            }
            System.out.println("[Invalid Input] Department cannot be empty.");
        }

        double salary = 0;
        while (true) {
            System.out.println("Enter Salary: ");
            try {
                salary = Double.parseDouble(scanner.nextLine().trim());
                if (salary > 0) {
                    break;
                }
                System.out.println("[Invalid Input] Salary must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("[Invalid Input] Please enter a valid decimal number for salary.");
            }
        }

        int experience = 0;
        while (true) {
            System.out.println("Enter Years of Experience: ");
            try {
                experience = Integer.parseInt(scanner.nextLine().trim());
                if (experience >= 0) {
                    break;
                }
                System.out.println("[Invalid Input] Experience cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("[Invalid Input] Please enter a valid whole number for experience.");
            }
        }

        String email = "";
        while (true) {
            System.out.println("Enter Email Address: ");
            email = scanner.nextLine().trim();
            // FIXED: Changed four backslashes to two (\\.) to properly match standard domains
            if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                break;
            }
            System.out.println("[Invalid Input] Please enter a well-formatted email (e.g., name@company.com).");
        }

        return new Employee(empId, name, department, salary, experience, email);
    }

    private static IncrementInfo getPercentageIncrement(Scanner scanner) throws InvalidEmployeeIdException {
        long empId = 0;
        while (true) {
            System.out.println("Enter employee ID: ");
            try {
                empId = Long.parseLong(scanner.nextLine().trim());
                if (empId > 0) {
                    break;
                }
                throw new InvalidEmployeeIdException("[Invalid Input] Employee ID cannot be zero or negative.");

                //System.out.println("[Invalid Input] Employee ID cannot be negative.");
            } catch (NumberFormatException e) {
                throw new InvalidEmployeeIdException("[Invalid Input] Please enter a valid whole number for employeeId.", e.getCause());
                // System.out.println("[Invalid Input] Please enter a valid whole number for employeeId.");
            }
        }
        double incrementPercentage = 0;
        while (true) {
            System.out.println("Enter Salary Increment percentage: ");
            try {
                incrementPercentage = Double.parseDouble(scanner.nextLine().trim());
                if (incrementPercentage >= 0) {
                    break;
                }
                System.out.println("[Invalid Input] Salary Increment percentage must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("[Invalid Input] Please enter a valid decimal number for salary Increment percentage.");
            }
        }

        return new IncrementInfo(empId, incrementPercentage);
    }
}
