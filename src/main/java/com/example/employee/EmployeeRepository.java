// Write your code here
package com.example.employee;

import com.example.employee.Employee;
import java.util.ArrayList;

public interface EmployeeRepository{
    ArrayList<Employee> getEmployeesDetails();
    Employee addEmployeeDetails(Employee employee);
    Employee getEmployee(int employeeId);
    Employee updateEmployeeDetails(int employeeId, Employee employee);
    void deleteEmployeeDetails(int employeeId);
}