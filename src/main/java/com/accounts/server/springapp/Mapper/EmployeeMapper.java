package com.accounts.server.springapp.Mapper;

import com.accounts.server.springapp.DTO.EmployeeDTO;
import com.accounts.server.springapp.Model.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee,EmployeeDTO employeeDTO){
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setMobileNum(employee.getMobileNum());
        employeeDTO.setManagerId(employee.getManagerId());
        employeeDTO.setPanNum(employee.getPanNum());
        return employeeDTO;
    }
    public static Employee mapToEmployee(EmployeeDTO employeeDTO,Employee employee){
        employee.setFullName(employeeDTO.getFullName());
        employee.setMobileNum(employeeDTO.getMobileNum());
        employee.setManagerId(employeeDTO.getManagerId());
        employee.setPanNum(employeeDTO.getPanNum());
        return employee;
    }
}
