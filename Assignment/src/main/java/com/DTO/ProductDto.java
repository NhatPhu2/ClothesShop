package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class ProductDto implements Serializable {
    private final Integer id;
    private final String name;
    private final double price;
    private final String description;
    private final String photo;
    private final int quantity;
    private final Date createDate;
}
