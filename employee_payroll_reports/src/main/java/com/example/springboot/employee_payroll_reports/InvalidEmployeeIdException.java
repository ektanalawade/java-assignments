/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springboot.employee_payroll_reports;

/**
 *
 * @author ekata
 */
public class InvalidEmployeeIdException extends Exception {

    public InvalidEmployeeIdException() {
        super();
    }

    public InvalidEmployeeIdException(String message) {
        super(message);
    }

    public InvalidEmployeeIdException(String message, Throwable cause) {
        super(message, cause);
    }

}
