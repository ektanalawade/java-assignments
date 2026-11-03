package com.example.springboot.employee_payroll_reports;

import java.awt.event.ItemEvent;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ekata
 */
public class EmployeeService {

// Find all employees belonging to IT.
    List<Employee> findAllEmployeesByDepartment(List<Employee> employees, String department) {
        return employees.stream().filter(emp -> emp.getDepartment().equalsIgnoreCase(department)).collect(Collectors.toList());
    }

// Find employees with salary greater than 75,000.
    List<Employee> findAllEmployeesWithSalaryGreaterThan75K(List<Employee> employees) {
        return employees.stream().filter(emp -> emp.getSalary() > 75000).collect(Collectors.toList());
    }

// Find the employee with the highest salary.
    Employee findEmployeeWithHighestSalary(List<Employee> employees) {
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);

    }

// Calculate average salary overall and department-wise.
    Map<String, Double> DepartmentWiseAvgSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

    }

// Group employees by department.
    Map<String, List<Employee>> DepartmentWiseEmployees(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

// Find the Second-highest distinct salary.
    double secondHighestDistinctSalary(List<Employee> employees) {
        return employees.stream().mapToDouble(Employee::getSalary)// Returns DoubleStream (primitive)
                .distinct()
                .boxed() // Converts to Stream<Double> (object wrapper)
                .sorted(Comparator.reverseOrder()) // works because it's an object stream
                .skip(1).findFirst().orElse(0.0);
    }

// Sort employees by salary descending.
    List<Employee> SortEmployeeBySalaryDecendingOrder(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
    }

// Find the highest-paid employee in each department.
    Map<String, Employee> findHighestPaidEmployeeByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
    }

// Find duplicate email addresses.
    List<String> findDuplicateEmailAddresss(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getEmail, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

//Implement an employee salary-increment operation.
    void incrementEmployeeSalaryByPercentage(List<Employee> employees, IncrementInfo info) {

        employees.stream().filter(emp -> emp.getId() == info.id())
                .findFirst().
                ifPresent(emp -> emp.setSalary(emp.getSalary() * (1 + (info.incrementPercentage() / 100.0))));
        System.out.println("Employee Salary after increment");
        employees.stream().forEach(emp -> System.out.println(emp.getName() + " " + emp.getDepartment() + " " + emp.getSalary()));

    }

}
