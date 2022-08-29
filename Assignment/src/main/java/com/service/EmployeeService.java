package com.service;

import com.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    EmployeeDto findById(Integer id);
    void create(EmployeeDto EmployeeDto);
    void update(EmployeeDto EmployeeDto);
    void remove(Integer id);
}
