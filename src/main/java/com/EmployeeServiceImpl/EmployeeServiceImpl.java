package com.EmployeeServiceImpl;

import com.Employee.dto.EmployeeDTO;
import com.Employee.entities.EmployeeEntity;
import com.EmployeeRepository.EmployeeRepository;
import com.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employeeDTO.getName());
        entity.setEmail(employeeDTO.getEmail());

        employeeRepository.save(entity);

        return "Saved Successfully";
    }

    @Override
    public List<EmployeeDTO> readEmployees() {

        List<EmployeeEntity> list = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = new ArrayList<>();

        for (EmployeeEntity e : list) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(e.getId());
            dto.setName(e.getName());
            dto.setEmail(e.getEmail());
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public EmployeeDTO readEmployee(Long id) {

        Optional<EmployeeEntity> opt = employeeRepository.findById(id);

        if (opt.isPresent()) {
            EmployeeEntity e = opt.get();

            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(e.getId());
            dto.setName(e.getName());
            dto.setEmail(e.getEmail());

            return dto;
        }

        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateEmployee(Long id, EmployeeDTO employeeDetails) {

        Optional<EmployeeEntity> opt = employeeRepository.findById(id);

        if (opt.isPresent()) {

            EmployeeEntity entity = opt.get();

            entity.setName(employeeDetails.getName());
            entity.setEmail(employeeDetails.getEmail());

            employeeRepository.save(entity);

            return true;
        }

        return false;
    }
}