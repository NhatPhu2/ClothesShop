package com.service;

import com.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(Integer id);
    void create(EmployeeDTO EmployeeDto);
    void update(EmployeeDTO EmployeeDto);
    void remove(Integer id);
}
