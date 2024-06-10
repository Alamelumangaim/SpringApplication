package com.accounts.server.springapp.Service;

import com.accounts.server.springapp.DTO.EmployeeDTO;
import com.accounts.server.springapp.Model.Employee;

import java.util.List;

public interface IEmployee {
    void createUser(EmployeeDTO employeeDTO);
    List<Employee> getUsers();
    Employee getUser(String mobileNum);
    void updateUser(EmployeeDTO employeeDTO);
}
