package com.accounts.server.springapp.Exception;

import com.accounts.server.springapp.Model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalTime;

public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException employeeAlreadyExistsException, WebRequest webRequest){
        ErrorDTO errorDTO = new ErrorDTO(
                webRequest.getDescription(false),
                employeeAlreadyExistsException.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalTime.now()
        );
        return new ResponseEntity<>(errorDTO,HttpStatus.BAD_REQUEST);
    }
}
