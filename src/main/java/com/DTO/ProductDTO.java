package com.DTO;

import com.entity.Category;
import com.entity.Color;
import com.entity.ProductType;
import com.entity.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String photo;
    private int quantity;
    private Date createDate;
    private Size size;
    private Color color;
    private Category category;
    private ProductType productType;
}
