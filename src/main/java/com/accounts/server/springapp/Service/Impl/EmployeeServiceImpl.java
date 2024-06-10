package com.accounts.server.springapp.Service.Impl;

import com.accounts.server.springapp.DTO.EmployeeDTO;
import com.accounts.server.springapp.Exception.EmployeeAlreadyExistsException;
import com.accounts.server.springapp.Exception.ResourceNotFoundException;
import com.accounts.server.springapp.Mapper.EmployeeMapper;
import com.accounts.server.springapp.Model.Employee;
import com.accounts.server.springapp.Repository.EmployeeRepository;
import com.accounts.server.springapp.Service.IEmployee;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
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

    @Override
    public List<Employee> getUsers() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getUser(String mobileNum) {
        Employee employee;
        employee = employeeRepository.findByMobileNum(mobileNum).orElseThrow(
                ()->new ResourceNotFoundException("Requested details not found")
        );
        return employee;
    }

    @Override
    public void updateUser(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findByMobileNum(employeeDTO.getMobileNum())
                .orElseThrow(()->new ResourceNotFoundException("Employee with the mobile number not exists"));
        Employee employee1 = EmployeeMapper.mapToEmployee(employeeDTO,employee);
        employeeRepository.save(employee1);
    }

    @Override
    public void deleteUser(String mobileNum) {
        Employee employee = employeeRepository.findByMobileNum(mobileNum)
                .orElseThrow(()->new ResourceNotFoundException("Employee with the mobile number not exists"));
        employeeRepository.deleteById(employee.getId());
    }
}
