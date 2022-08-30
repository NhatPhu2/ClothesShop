package com.DTO;

import com.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class OrdersDto implements Serializable {
    private final Integer id;
    private final Date createDate;
    private final String address;
    private final Customer orderCustomer;
}
