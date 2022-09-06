package com.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Integer idProduct;
    private String nameProduct;
    private double price;
    private String description;
    private Date createDate;
    private String nameCategory;

}
