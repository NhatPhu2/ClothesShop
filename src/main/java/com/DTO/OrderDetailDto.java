package com.DTO;

import com.entity.Orders;
import com.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class OrderDetailDto implements Serializable {
    private final Integer id;
    private final int quantity;
    private final double amount;
    private final Product orderDetailProduct;
    private final Orders order;
}
