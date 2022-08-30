package com.service;

import com.DTO.ProductTypeDTO;

import java.util.List;

public interface ProductTypeService {
    List<ProductTypeDTO> findAll();
    ProductTypeDTO findById(Integer id);
    void create(ProductTypeDTO ProductTypeDto);
    void update(ProductTypeDTO ProductTypeDto);
    void remove(Integer id);
}
