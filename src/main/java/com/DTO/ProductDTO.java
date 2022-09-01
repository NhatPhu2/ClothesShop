package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDTO implements Serializable {
    private  Integer id;
    private  String name;
    private  double price;
    private  String description;
    private  String photo;
    private  int quantity;
    private  Date createDate;
}
