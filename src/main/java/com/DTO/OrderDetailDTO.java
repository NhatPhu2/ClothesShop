package com.DTO;

import com.entity.Orders;
import com.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderDetailDTO implements Serializable {
    private Integer id;
    private int quantity;
    private double amount;
    private Product orderDetailProduct;
    private Orders order;
}
