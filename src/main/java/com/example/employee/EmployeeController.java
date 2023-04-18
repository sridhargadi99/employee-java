/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.employee;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.employee.EmployeeService;
import com.example.employee.Employee;
import java.util.*;

@RestController
public class EmployeeController{
    EmployeeService service = new EmployeeService();

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployeesDetails(){
        return service.getEmployeesDetails();
    }

    @PostMapping("/employees")
    public Employee addEmployeeDetails(@RequestBody Employee employee){
        return service.addEmployeeDetails(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId){
        return service.getEmployee(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployeeDetails(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee){
        return service.updateEmployeeDetails(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeDetails(@PathVariable("employeeId") int employeeId){
        service.deleteEmployeeDetails(employeeId);
    }
    
}