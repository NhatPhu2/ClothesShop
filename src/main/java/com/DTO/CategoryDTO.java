package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class CategoryDTO implements Serializable {
    private Integer idCategory;
    private String nameCategory;
}
