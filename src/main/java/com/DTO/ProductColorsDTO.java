package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ProductColorsDTO implements Serializable {
    private Integer idColor;
    private String nameColor;
    private String photoColor;
}
