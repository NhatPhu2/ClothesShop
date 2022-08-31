package com.DTO;

import com.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class OrdersDTO implements Serializable {
    private Integer id;
    private Date createDate;
    private String address;
    private Customer orderCustomer;
}
