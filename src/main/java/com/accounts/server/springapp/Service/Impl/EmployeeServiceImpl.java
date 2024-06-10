package com.accounts.server.springapp.Service.Impl;

import com.accounts.server.springapp.DTO.EmployeeDTO;
import com.accounts.server.springapp.Exception.EmployeeAlreadyExistsException;
import com.accounts.server.springapp.Mapper.EmployeeMapper;
import com.accounts.server.springapp.Model.Employee;
import com.accounts.server.springapp.Repository.EmployeeRepository;
import com.accounts.server.springapp.Service.IEmployee;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployee {
    private final EmployeeRepository employeeRepository;

    @Override
    public void createUser(EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findByMobileNum(employeeDTO.getMobileNum());
        Optional<Employee> employee2 = employeeRepository.findByPanNum(employeeDTO.getPanNum());
        if(employee.isPresent() || employee2.isPresent()){
            throw new EmployeeAlreadyExistsException("Employee already exists");
        }
        Employee employee1 = EmployeeMapper.mapToEmployee(employeeDTO,new Employee());
        employeeRepository.save(employee1);
    }
}
