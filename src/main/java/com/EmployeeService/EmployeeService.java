package com.EmployeeService;

import com.Employee.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    String createEmployee(EmployeeDTO employee); // Employee ऐवजी EmployeeDTO
    List<EmployeeDTO> readEmployees();           // हे आता तुझ्या क्लासशी मॅच होईल
    boolean deleteEmployee(Long id);
    EmployeeDTO readEmployee(Long id);           // Employee ऐवजी EmployeeDTO
    boolean updateEmployee(Long id, EmployeeDTO employee); // Employee ऐवजी EmployeeDTO
}