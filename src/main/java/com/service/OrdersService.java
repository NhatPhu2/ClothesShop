package com.service;

import com.DTO.OrdersDTO;

import java.util.List;

public interface OrdersService {
    List<OrdersDTO> findAll();
    OrdersDTO findById(Integer id);
    void create(OrdersDTO OrdersDto);
    void update(OrdersDTO OrdersDto);
    void remove(Integer id);
}
