package com.ems.EmployeeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
