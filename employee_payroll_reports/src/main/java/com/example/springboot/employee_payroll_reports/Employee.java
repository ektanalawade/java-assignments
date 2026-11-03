/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springboot.employee_payroll_reports;

import java.util.Objects;
import javax.annotation.processing.Generated;

/**
 *
 * @author ekata
 */
public class Employee implements Comparable<Employee> {

    private long id;
    private String name;
    private String department;
    private double salary;
    private int exeperience;
    private String email;

    public Employee(long id, String name, String department, double salary, int exeperience, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.exeperience = exeperience;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getExeperience() {
        return exeperience;
    }

    public String getEmail() {
        return email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + ", exeperience=" + exeperience + ", email=" + email + '}';
    }

    //prevent duplicate employee based on id 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return id == employee.id;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//sort by id 
    @Override
    public int compareTo(Employee e) {
        return Long.compare(this.id, e.id);
    }

}
