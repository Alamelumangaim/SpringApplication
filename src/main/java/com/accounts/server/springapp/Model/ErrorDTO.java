package com.accounts.server.springapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDTO {
    private String apiPath;
    private String errorMsg;
    private HttpStatus statusCode;
    private LocalTime errorTime;
}
