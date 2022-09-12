package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ProductSizesDTO implements Serializable {
    private Integer idSize;
    private String nameSize;
    private int quantity;
}
