package com.accounts.server.springapp.Controller;

import com.accounts.server.springapp.DTO.EmployeeDTO;
import com.accounts.server.springapp.Model.ResponseDTO;
import com.accounts.server.springapp.Service.IEmployee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
