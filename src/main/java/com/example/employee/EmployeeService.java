/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */


package com.example.employee;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;

import java.util.*;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();
    int updateEmployeeId = 7;

    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    // Write your code here
    @Override
    public ArrayList<Employee> getEmployeesDetails(){
        Collection<Employee> emloyeeCollection = employeeList.values();
        ArrayList<Employee> employees = new ArrayList<>(emloyeeCollection);
        return employees;
    }
    
    @Override 
    public Employee addEmployeeDetails(Employee employee){
        employee.setEmployeeId(updateEmployeeId);
        employeeList.put(updateEmployeeId, employee);
        updateEmployeeId += 1;
        return employee;
    }

    @Override 
    public Employee getEmployee(int employeeId){
        Employee newEmployee = employeeList.get(employeeId);
        if(newEmployee == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return newEmployee;
    }

    @Override 
    public Employee updateEmployeeDetails(int employeeId, Employee employee){
        Employee existingEmployee = employeeList.get(employeeId);
        if(existingEmployee == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(employee.getEmployeeName() != null){
            existingEmployee.setEmployeeName(employee.getEmployeeName());
        }
        if(employee.getEmail() != null){
            existingEmployee.setEmail(employee.getEmail());
        }
        if(employee.getDepartment() != null){
            existingEmployee.setDepartment(employee.getDepartment());
        }
        return existingEmployee;
    }

    @Override 
    public void deleteEmployeeDetails(int employeeId){
        Employee existingEmployee = employeeList.get(employeeId);
        if(existingEmployee == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            employeeList.remove(employeeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
