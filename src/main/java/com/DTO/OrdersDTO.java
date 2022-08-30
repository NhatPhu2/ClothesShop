package com.DTO;

import com.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class OrdersDTO implements Serializable {
    private final Integer id;
    private final Date createDate;
    private final String address;
    private final Customer orderCustomer;
}
