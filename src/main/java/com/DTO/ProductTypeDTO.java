package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductTypeDTO implements Serializable {
    private Integer idProductType;
    private String nameProductType;
}
