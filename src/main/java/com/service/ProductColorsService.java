package com.service;

import com.DTO.ProductColorsDTO;

import java.util.List;

public interface ProductColorsService {
    List<ProductColorsDTO> findAll();
    ProductColorsDTO findById(Integer id);
    void create(ProductColorsDTO ProductColorsDto);
    void update(ProductColorsDTO ProductColorsDto);
    void remove(Integer id);
}
