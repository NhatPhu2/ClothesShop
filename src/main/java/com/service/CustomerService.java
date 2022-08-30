package com.service;

import com.DTO.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();
    CustomerDto findById(Integer id);
    void create(CustomerDto CustomerDto);
    void update(CustomerDto CustomerDto);
    void remove(Integer id);
}
