package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductColorsDTO implements Serializable {
    private Integer idProductColor;
    private String photo;
}
