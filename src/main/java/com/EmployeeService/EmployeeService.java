package com.EmployeeService;

import com.Employee.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    String createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> readEmployees();
    EmployeeDTO readEmployee(Long id);
    boolean deleteEmployee(Long id);
    boolean updateEmployee(Long id, EmployeeDTO employeeDTO);
}