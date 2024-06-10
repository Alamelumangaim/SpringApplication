package com.accounts.server.springapp.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;
@Data
public class EmployeeDTO {
    @NotEmpty(message = "Name field cannot be empty")
    @Size(min = 5,max = 30)
    private String fullName;
    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number should be in 10 digits")
    private String mobileNum;
    @NotEmpty(message = "Pan number cannot be empty")
    @Pattern(regexp = "^$|[A-Z]{10}", message = "Pan number should be in 10 characters")
    private String panNum;
    private UUID managerId;
}
