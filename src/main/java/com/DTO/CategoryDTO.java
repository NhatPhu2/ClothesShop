package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class CategoryDTO implements Serializable {
    private final Integer id;
    private final String name;
}
