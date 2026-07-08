package com.Employee.mapper;

import com.Employee.dto.EmployeeDTO;
import com.Employee.entities.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(EmployeeEntity entity);
    EmployeeEntity toEntity(EmployeeDTO dto);
}