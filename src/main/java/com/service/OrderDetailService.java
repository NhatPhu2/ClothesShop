package com.service;

import com.DTO.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDTO> findAll();
    OrderDetailDTO findById(Integer id);
    OrderDetailDTO create(OrderDetailDTO OrderDetailDto);
    void update(OrderDetailDTO OrderDetailDto);
    void remove(Integer id);
}
