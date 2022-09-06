package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ProductColorsDTO implements Serializable {
    private Integer idProduct;
    private String nameProduct;
    private double price;
    private String photo;
    private int quantity;
    private Integer idColor;
    private String nameColor;
}
