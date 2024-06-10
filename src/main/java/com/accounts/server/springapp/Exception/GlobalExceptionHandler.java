package com.accounts.server.springapp.Exception;

import com.accounts.server.springapp.Model.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> validErrors = new HashMap<>();
        List<ObjectError> validErrorList = ex.getBindingResult().getAllErrors();
        validErrorList.forEach((error)->{
            String validation = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            validErrors.put(validation,message);
        });
        return new ResponseEntity<>(validErrors,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(Exception exception,WebRequest webRequest){
        ErrorDTO errorDTO = new ErrorDTO(
                webRequest.getDescription(false),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalTime.now()
        );
        return new ResponseEntity<>(errorDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }
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
