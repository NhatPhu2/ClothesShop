package com.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Integer idProduct;
    private String name;
    private double price;
    private String description;
    private String photo;
    private int quantity;
    private Date createDate;
    private Integer idSize;
    private String nameSize;
    private Integer idCategory;
    private String nameCategory;
    private Integer idProductType;
    private String nameProductType;

//    private Color color;
//    private Category category;
//    private ProductType productType;
}
