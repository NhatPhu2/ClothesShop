package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Getter
@NoArgsConstructor
public class ProductSizesDTO implements Serializable {
    private Integer idProductSize;
    private int quantity;
}
