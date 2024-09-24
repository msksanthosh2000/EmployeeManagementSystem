package com.ems.EmployeeManagement.service;

import com.ems.EmployeeManagement.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById(long empId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(long empId, EmployeeDto employeeDto);

    void deleteEmployee(long empId);
}
