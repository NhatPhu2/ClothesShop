package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class OrdersDTO implements Serializable {
    private Integer idOrder;
    private Date createDate;
    private String address;
    private String username;
}
