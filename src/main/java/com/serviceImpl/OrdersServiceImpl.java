package com.serviceImpl;

import com.DAO.OrdersDAO;
import com.DTO.OrdersDTO;
import com.entity.Orders;
import com.service.OrdersService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersDAO ordersDAO;

    @Autowired
    Convert convert;
    @Override
    public List<OrdersDTO> findAll() {
        return null;
    }

    @Override
    public OrdersDTO findById(Integer id) {
        return null;
    }

    @Override
    public OrdersDTO create(OrdersDTO OrdersDto) {
        Orders orders = convert.toEntity(OrdersDto,Orders.class);
        OrdersDTO ordersDTO = convert.toDto(ordersDAO.save(orders),OrdersDTO.class);
        return ordersDTO;
    }

    @Override
    public void update(OrdersDTO OrdersDto) {

    }

    @Override
    public void remove(Integer id) {

    }
}
