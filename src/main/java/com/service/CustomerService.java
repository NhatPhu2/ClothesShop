package com.service;

import com.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();
    CustomerDTO findById(Integer id);
    void create(CustomerDTO CustomerDto);
    void update(CustomerDTO CustomerDto);
    void remove(Integer id);
}
