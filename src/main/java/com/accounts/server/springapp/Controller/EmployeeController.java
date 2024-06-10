package com.accounts.server.springapp.Controller;

import com.accounts.server.springapp.DTO.EmployeeDTO;
import com.accounts.server.springapp.Model.Employee;
import com.accounts.server.springapp.Model.ResponseDTO;
import com.accounts.server.springapp.Service.IEmployee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api")
@Validated
public class EmployeeController {
    private final IEmployee employeeService;
    @PostMapping("/create_user")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody EmployeeDTO employeeDTO){
        employeeService.createUser(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO("CREATED_SUCCESSFULLY","201"));
    }
    @PostMapping("/get_users")
    public ResponseEntity<List<Employee>> getUsers(){
        List<Employee> employees = employeeService.getUsers();
        return ResponseEntity.status(HttpStatus.OK)
        .body(employees);
    }
    @PostMapping("/get_user")
    public ResponseEntity<Employee> getUser(@RequestParam String mobileNum){
        Employee employee = employeeService.getUser(mobileNum);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employee);
    }
    @PostMapping("/update_user")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody EmployeeDTO employeeDTO){
        employeeService.updateUser(employeeDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO("Updated successfully","200"));
    }

}
