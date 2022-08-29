package com.service;

import com.DTO.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDto> findAll();
    OrderDetailDto findById(Integer id);
    void create(OrderDetailDto OrderDetailDto);
    void update(OrderDetailDto OrderDetailDto);
    void remove(Integer id);
}
