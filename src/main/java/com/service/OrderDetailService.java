package com.service;

import com.DTO.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDTO> findAll();
    OrderDetailDTO findById(Integer id);
    void create(OrderDetailDTO OrderDetailDto);
    void update(OrderDetailDTO OrderDetailDto);
    void remove(Integer id);
}
