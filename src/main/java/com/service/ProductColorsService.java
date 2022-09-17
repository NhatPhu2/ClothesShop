package com.service;

import com.DTO.ProductColorsDTO;

import java.util.List;

public interface ProductColorsService {
    List<ProductColorsDTO> findAll();
    ProductColorsDTO findById(Integer id);

    ProductColorsDTO findByIdColorAndIdProduct(Integer idColor, Integer idProduct);

    ProductColorsDTO create(ProductColorsDTO ProductColorsDto);
    ProductColorsDTO update(ProductColorsDTO ProductColorsDto);
    void remove(Integer id);

    List<ProductColorsDTO> findByIdColor(Integer idColor);

    List<ProductColorsDTO> findByIdProduct(Integer idProduct);
}
