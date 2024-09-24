package com.ems.EmployeeManagement.service.impl;

import com.ems.EmployeeManagement.dto.EmployeeDto;
import com.ems.EmployeeManagement.entity.Employee;
import com.ems.EmployeeManagement.exception.ResourceNotFoundException;
import com.ems.EmployeeManagement.mapper.EmployeeMapper;
import com.ems.EmployeeManagement.repository.EmployeeRepository;
import com.ems.EmployeeManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = repository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long empId) {
        Employee employee = repository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee is not found Exist with given id : " + empId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = repository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(long empId, EmployeeDto employeeDto) {

        Employee employee = repository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee is not found Exist with given id : " + empId));

        if (employee != null) {
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employee.getEmail());
        }

        Employee updatedEmployee = repository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(long empId) {
        Employee employee = repository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee is not found Exist with given id : " + empId));

        repository.deleteById(empId);
    }
}
