package com.service;

import com.DTO.OrdersDto;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> findAll();
    OrdersDto findById(Integer id);
    void create(OrdersDto OrdersDto);
    void update(OrdersDto OrdersDto);
    void remove(Integer id);
}
